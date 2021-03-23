package com.ibm.rest.webservices.restfulwebservices.projectteam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChart;
import com.ibm.rest.webservices.restfulwebservices.resource.Resource;
import com.ibm.rest.webservices.restfulwebservices.wbselement.WbsElement;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="PROJECTRESOURCE")
public class ProjectMember {

	@Id
	@Column(name = "PROJECT_RESOURCE_ID")
	@SequenceGenerator(name = "SEQ_PROJECTMEMBER", sequenceName = "SEQ_PROJECTMEMBER", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_PROJECTMEMBER")

	private Integer id;
	
	private Integer claimHours;
	
	private Integer weekNumber;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	private Project project ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESOURCE_ID")
	private Resource resource ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RATECHART_ID")
	private RateChart rateChart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICECYCLE_ID")
	private InvoiceCycle invoiceCycle ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WBS_ELEMENT_ID")
	private WbsElement wbsElement;

	public ProjectMember() {

	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	



	



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public Resource getResource() {
		return resource;
	}



	public void setResource(Resource resource) {
		this.resource = resource;
	}



	public RateChart getRateChart() {
		return rateChart;
	}



	public void setRateChart(RateChart rateChart) {
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



	public InvoiceCycle getInvoiceCycle() {
		return invoiceCycle;
	}



	public void setInvoiceCycle(InvoiceCycle invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}







	public ProjectMember(Integer id, Integer claimHours, Integer weekNumber, Project project, Resource resource,
			RateChart rateChart, InvoiceCycle invoiceCycle) {
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
		return "ProjectResouces [id=" + id + ", employeeName=" + resource.getEmployeeName() + ",  project=" + project.getProjectName() + ", rateChart=" + rateChart.getDesc() + "]";
	}


	
	


	
}
