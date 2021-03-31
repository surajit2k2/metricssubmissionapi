FROM openjdk
MAINTAINER Surajit Mukhopadhyay
ADD target/metrics-api-0.0.1-SNAPSHOT.jar metrics-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/metrics-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080