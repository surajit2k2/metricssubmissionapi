package com.ibm.rest.webservices.restfulwebservices.projectteam;

import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycleDTO;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.project.ProjectDTO;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChart;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChartDTO;
import com.ibm.rest.webservices.restfulwebservices.resource.Resource;
import com.ibm.rest.webservices.restfulwebservices.resource.ResourceDTO;

public class ProjectMemberDTO {

	private Integer id;

	private Integer claimHours;

	private Integer weekNumber;

	private ProjectDTO project;

	private ResourceDTO resource;

	private RateChartDTO rateChart;

	private InvoiceCycleDTO invoiceCycle;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public ResourceDTO getResource() {
		return resource;
	}

	public void setResource(ResourceDTO resource) {
		this.resource = resource;
	}

	public RateChartDTO getRateChart() {
		return rateChart;
	}

	public void setRateChart(RateChartDTO rateChart) {
		this.rateChart = rateChart;
	}

	public Integer getClaimHours() {
		return claimHours;
	}

	public void setClaimHours(Integer claimHours) {
		this.claimHours = claimHours;
	}

	
	
	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	public InvoiceCycleDTO getInvoiceCycle() {
		return invoiceCycle;
	}

	public void setInvoiceCycle(InvoiceCycleDTO invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}

	

	public ProjectMemberDTO() {
		super();
	}

	
	
	public ProjectMemberDTO(Integer id, Integer claimHours, Integer weekNumber, ProjectDTO project, ResourceDTO resource,
			RateChartDTO rateChart, InvoiceCycleDTO invoiceCycle) {
		super();
		this.id = id;
		this.claimHours = claimHours;
		this.weekNumber = weekNumber;
		this.project = project;
		this.resource = resource;
		this.rateChart = rateChart;
		this.invoiceCycle = invoiceCycle;
	}

	@Override
	public String toString() {
		return "ProjectResouces [id=" + id + ", employeeName=" + resource.getEmployeeName() + ",  project="
				+ project.getProjectName() + ", rateChart=" + rateChart.getDesc() + "]";
	}

}
