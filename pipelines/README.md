# Automated Build & Deployment - Openshift Pipelines (Tekton)

## Table of Contents

1. Prerequisite
2. New Openshift project under your cluster
3. IBM Github Enterprise connection with Openshift Pipeline
4. Tasks
5. Pipeline
6. Pipeline Run
7. Webhook
8. Trigger Bindings and Template
9. Setup

## Prerequisite

For this Openshift pipeline setup, we will need:
1. IBM Github login and access to the code repository
2. Access to Openshift cluster 
3. Openshift Pipeline operator installed from Operator Hub

## New Openshift project under your cluster

Your Openshift cluster may have one or more projects to run multiple applications. Recommended pattern is to create a new project in your cluster named `devops` and put all your project pipelines to a single project so that we are able to reuse the pipeline template tasks, triggers etc.

## IBM Github Enterprise connection with Openshift Pipeline

1. Create a secret to link your Github profile access to Openshift Pipeline. 
2. This can be done by going to `github.ibm.com -> Your Profile -> Settings -> Developer Settings -> Personal Access Tokens` and "Generate new token".
3. Update your Github IBM email-id as `username` and generated token as `password` in the sample reference Secret file - `Secrets/ibm-github-secret.yaml`

![alt text](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/images/github-access-token.png "Github access token")

## The flow

We are going to build the following flow to integrate Github with Openshift Pipelines and subsequent build and deploy to Openshift cluster.

![alt text](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/images/Flow.png "Pipeline flow")

## Tasks

The pipeline consists of one or more tasks and for our demonstration, we have broken down into 3 distinct tasks:
1. Cloning GIT repository
2. Build, test and code scan for Maven projects
3. Build and push image to container registry
4. Scan the image for vulnerabilities (CVS)
5. Deploy image to a Kubernetes cluster

### Clone the repository

The first thing that the pipeline needs is a task to clone the Git repository that the pipeline is building. Tekton provides a library of reusable tasks called the Tekton catalog. It provides a `git-clone` task which is described [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/tasks/git-clone-task.yaml)

A task can have parameters. Parameters help to make a task reusable. This task accepts many parameters such as:
1. the URL of the Git repository to clone
2. the revision to check out
Parameters can have default values provided by the task or the values can be provided by the Pipeline and PipelineRun resources that we'll see later. Steps can reference parameter values by using the syntax $(params.name) where name is the name of the parameter. For example the step uses $(params.url) to reference the url parameter value.

The task requires a workspace where the clone is stored. From the point of view of the task, a workspace provides a file system path where it can read or write data. Steps can reference the path using the syntax $(workspaces.name.path) where name is the name of the workspace. We'll see later how the workspace becomes associated with a storage volume.

Apply the file to `your cluster` to create the task.
`oc apply -f https://raw.githubusercontent.com/tektoncd/catalog/v1beta1/git/git-clone.yaml`

### Build, test and code scan for Maven projects

This task will prepare the code for scanning using any static code analyser tool - here we have used Sonar.
To enable Sonar scan of the code, first Sonar needs to be run as a container in this project space.

Apply the file `sonarqube.yaml` to create the Sonarqube deployment:
`oc apply -f pipeline/setup/sonarqube.yaml`

Once this has been run, sonar will be found running in `http://sonarqube:9090`
To see it in the browser, select the URL from `sonar` from the `Routes` in Openshift admin.
e.g.
`https://sonarqube-devops.roks-cp4a-2face0433451d5f4f63e8f7ab10f8f12-0000.eu-de.containers.appdomain.cloud/`

Then we need to create the task which will execute the build, test and sonar scan step using
`oc apply -f pipeline/tasks/java-maven-sonar.yaml`

Once this has run as part of the pipeline, the results can be seen at:
`<Route URL>/dashboard?id=<gitRepo variable value from triggerBinding>`

### Build and push image to container registry

The next function that the pipeline needs is a task that builds a docker image and pushes it to a container registry. The catalog provides a kaniko task which does this using Google's `kaniko` tool. The task is described [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/tasks/build-and-pushimage-task.yaml)

Apply the file to your cluster to create the task.
`oc apply -f pipeline/tasks/build-and-pushimage-task.yaml`

### Scan the image for vulnerabilities (CVS)

This task scans the newly created container image for any security vulnerabilities before it is deployed, using IBM Container Vulnerability Advisor.
The task is described [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/tasks/img-scan-ibm.yaml)

Apply the file to your cluster to create the task.
`oc apply -f pipeline/tasks/img-scan-ibm.yaml`

### Deploy image to a Kubernetes cluster

If the above step is successful, then the final function that the pipeline needs is a task that deploys a docker image to a Kubernetes cluster. Below is a Tekton task that does this. You can find this yaml file [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/tasks/deploy-using-kubectl-task.yaml)

Apply the file to your cluster to create the task.
`oc apply -f pipeline/tasks/deploy-using-kubectl.yaml`

## Create a pipeline
Template for a Tekton pipeline that runs the tasks we defined above is [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/pipeline/appname-build-and-deploy-pipeline.yaml)

A Pipeline resource contains a list of tasks to run. Each pipeline task is assigned a name within the pipeline; here they are `clone-repo`, `source-to-image`, and `deploy-using-kubectl`.
The pipeline configures each task via the task's parameters. You can choose whether to expose a task parameter as a pipeline parameter, set the value directly, or let the value default inside the task (if it's an optional parameter). For example this pipeline exposes the 
`gitUrl`
`pathToContext` (will default to `src` if none provided in Pipeline Run)
`pathToYamlFile` 
`imageUrl`
`imageTag` (will default to `latest` if none provided in Pipeline Run)
This does not expose the `DOCKERFILE` parameter and allows it to default inside the task.

By default Tekton assumes that pipeline tasks can be executed concurrently. In this pipeline each pipeline task depends on the previous one so they must be executed sequentially. One way that dependencies between pipeline tasks can be expressed is by using the runAfter key. It specifies that the task must run after the given list of tasks has completed. In this example, the pipeline specifies that the source-to-image pipeline task must run after the clone-repo pipeline task.

The deploy-using-kubectl pipeline task must run after the source-to-image pipeline task but it doesn't need to specify the runAfter key. This is because it references a task result from the source-to-image pipeline task and Tekton is smart enough to figure out that this means it must run after that task.

Apply the file to your cluster to create the pipeline.

`oc apply -f pipelines/pipeline/appname-build-and-deploy-pipeline.yaml`

## Define a service account
Before running the pipeline, we need to set up a service account so that it can access protected resources. The service account ties together a couple of secrets containing credentials for authentication along with RBAC-related resources for permission to create and modify certain Kubernetes resources.

First you need to enable programmatic access to your private container registry by creating an IBM Cloud Identity and Access Management (IAM) API key. The process for creating a user API key using ![alt text](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/images/create_api_key.png "Create API Key in IBM Cloud")

After you have the API key, you can create the following secret using Powershell in Windows:

`oc create secret generic ibm-registry-secret --type="kubernetes.io/basic-auth" --from-literal=username=iamapikey --from-literal=password=<CREATED_API_KEY>`

Assign the secret to your container registry URL to push & pull images from registry:

`oc annotate secret ibm-registry-secret tekton.dev/docker-0=<REGISTRY>`

`<CREATED_API_KEY>` is the API key that you created

`<REGISTRY>` is the domain name of your container registry, such as us.icr.io (you can find out the domain name of your registry using the command ibmcloud cr region)

Now you can create the service account using the following yaml. You can find this yaml file [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/secrets_serviceaccount_pvc/pipeline-account.yaml)

This yaml creates the following Kubernetes resources:

A ServiceAccount named `pipeline-account`. The service account references 
- the ibm-registry-secret secret so that the pipeline can authenticate to your private container registry when it pushes and pulls a container image.
- the ibm-github secret so that pipeline can authenticate to your github repo and clone the repo

A Secret named `kube-api-secret` which contains an API credential (generated by Kubernetes) for accessing the Kubernetes API. This allows the pipeline to use kubectl to talk to your cluster.

A Role named `pipeline-role` and a RoleBinding named `pipeline-role-binding` which provide the resource-based access control permissions needed for this pipeline to create and modify Kubernetes resources.

Apply the file to your cluster to create the service account and related resources.

`oc apply -f pipelines/setup/pipeline-account.yaml`

## Define Secret and Config Map for CVS image scan task

The same `<CREATED_API_KEY>` for a secret `ibmcloud-apikey` using the yaml file [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/secrets_serviceaccount_pvc/cloudapikey_secret.yaml)

Next create a config map to store the region where container registry is placed using the yaml file [here](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/secrets_serviceaccount_pvc/configmap.yaml)

Ref: For `region` value, refer this: https://cloud.ibm.com/docs/containers?topic=containers-regions-and-zones

## Pipeline Run

This will be explained as part of Trigger Template below

## Webhook

Webhook is required to integrate Github events (like pull request, merge) with Openshift Pipelines for build & deployment process.
Create a Tekton Trigger Webhook. The webhook will execute the pipeline upon the merge of a pull request / checkin to master branch.
First step is to expose public service and route which will enable external apps (like Github) to send events through that service.

`oc apply -f .\pipelines\triggers\`

This will create an `EventListener`, `EventListenerRoute`, `TriggerBinding` and `TriggerTemplate` resource.
The `EventListener` resource will create result in the creation of a `Deployment` and `Service`. `EventListenerRoute` will generate a route.

Retrieve the route URL of the eventlistener: `oc get routes`
This route URL will now to be added to the Webhook in GitHub project.

Here we are referring to the `smq-data-producer-app` project to create this webhook.

Go to: https://github.ibm.com/apmmcontainerization/smq-data-producer-app/settings/hooks and follow the steps below:

Payload URL = http://<Route of Eventlistener>
Content type = application/json

Which events would you like to trigger this webhook? = Send me everything
click Add Webhook.

![alt text](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/images/webhook1.png "Web Hook flow1")
![alt text](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/images/webhook2.png "Web Hook flow2")

### Trigger Binding
This was already executed before but needs to be updated if you want to capture specific events like `pull requests` and not everything as we are doing in this guide.
This configuration is also important as it maps between the attributes from Github event playload to the `params` used in Trigger Template (next in this) so that the Pipeline tasks get the correct values in each of the params.
Refer to our [example:](https://github.ibm.com/apmmcontainerization/smq-data-producer-app/blob/master/tekton-pipelines/WebHook/triggerBinding.yaml)
Example:
`  - name: gitUrl
    value: $(body.repository.url)
`
This maps `gitUrl` param with the attribute `body.repository.url` from Github event playload.

### Trigger Template

This configuration links the resources to the Pipeline we had created earlier in this guide.
This Yaml has two distinct sections:

#### params:

Defines the parameters which are required to accept events from Github and then trigger the pipeline through the resourcetemplate `PipelineRun`

In our [example](https://github.ibm.com/apmmcontainerization/smq-data-producer-app/blob/master/tekton-pipelines/WebHook/triggerTemplate.yaml), we are using the following with default values wherever required:
`gitUrl`
`gitRepo`
`serviceAccountName`
`imageContext`
`imageTag`

#### resourcetemplates:

Here we define the PipelineRun resource which triggers the Pipeline with "definite" input for params. If there is no integration with source code repo, you can also define `PipelineRun` resource separately. Refer the [template](https://github.ibm.com/apmmcontainerization/pipelines/blob/master/pipeline/appname-pipeline-run.yaml) here.

In this case, we define the `PipelineRun` resource as part of `TriggerTemplate`. You can refer the example [here](https://github.ibm.com/apmmcontainerization/smq-data-producer-app/blob/master/tekton-pipelines/WebHook/triggerTemplate.yaml) done for a specifc project.

## Setup

For Openshift cluster having multiple projects, recommended pattern is:
1. Create a separate project/namespace for devops in the Openshift cluster
2. Setup SonarQube to run as a container in this new project/namespace using 
3. Create all `template` tasks/resources"
    - pipelines/setup/ibm-github-secret.yaml
    - pipelines/setup/ibmcloud-apikey.yaml
    - pipelines/setup/configmap.yaml
    - pipelines/setup/sonarqube.yaml
    - pipelines/setup/pipeline-account.yaml
    - pipelines/tasks/shared-pipeline-pvc.yaml
    - pipelines/tasks/git-clone-task.yaml
    - pipelines/tasks/java-maven-sonar.yaml
    - pipelines/tasks/build-and-pushimage-task.yaml
    - pipelines/tasks/ibm-img-scan.yaml
    - pipelines/tasks/deploy-using-kubectl-task.yaml
NOTE: these all are common to all projects inside the same cluster - so ONE time only
3. Create `project specific` configurations separately (refer: project `smq-data-producer-app`):
    - Create pipeline: 
        smq-data-producer-app/tekton-pipelines/Pipeline/smq-data-producer-build-and-deploy-pipeline.yaml
    - Create webhook & triggers: 
        smq-data-producer-app/tekton-pipelines/WebHook/eventListener.yaml
        smq-data-producer-app/tekton-pipelines/WebHook/eventListenerRoute.yaml
        smq-data-producer-app/tekton-pipelines/WebHook/triggerBinding.yaml
        smq-data-producer-app/tekton-pipelines/WebHook/triggerTemplate.yaml

NOTE: 
1. In case and ONLY IF, your project/app requires priviledge to create directories on deployment, take note of the followign example:

For the `smq-data-producer-app`, we have a privilged service account defined as `controlplane` under `apmm-cp4a-demo` project. 
#### If the pod doesn't require `Privileged` access and can work under default restricted service account then no need to copy the SA. Otherwise follow below steps to copy the SA to desired project and use the same in deploy.yaml

```
oc get sa controlplane -n apmm-cp4a-demo -o yaml
	apiVersion: v1
	imagePullSecrets:
	- name: controlplane-dockercfg-cr44n
	kind: ServiceAccount
	metadata:
	name: controlplane
	namespace: apmm-cp4a-demo
	secrets:
	- name: controlplane-token-8cqwh
	- name: controlplane-dockercfg-cr44n
```
`oc get sa controlplane -n apmm-cp4a-demo -o yaml | sed 's/apmm-cp4a-demo/devops/g' | oc create -n devops -f -`

`oc get secret controlplane-token-8cqwh -n apmm-cp4a-demo -o yaml | sed 's/apmm-cp4a-demo/devops/g' | oc create -n devops -f -`

`oc get secret controlplane-dockercfg-cr44n -n apmm-cp4a-demo -o yaml | sed 's/apmm-cp4a-demo/devops/g' | oc create -n devops -f -`

## Further Reading & Reference:

1. Tekton Beta tutorial: https://github.com/IBM/tekton-tutorial/tree/beta-update
2. Openshift tutorial: https://github.com/openshift/pipelines-tutorial
3. IBM Cloud Architecture Openshift Pipeline guide: https://github.com/ibm-cloud-architecture/gse-devops
4. Tekton Triggers: https://github.com/tektoncd/triggers
5. IBM Cloud Architetcure tutorials: https://ibm-cloud-architecture.github.io/tutorials/
6. IBM CLoud Architecture Tekton tutorial: https://github.com/ibm-cloud-architecture/tutorial-tekton-pipeline

