package com.ibm.rest.webservices.restfulwebservices.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.contract.Contract;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;
import com.ibm.rest.webservices.restfulwebservices.wbselement.WbsElement;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="Project")
public class Project {

	@Id
	@Column(name = "PROJECT_ID")
	@SequenceGenerator(name = "SEQ_PROJECT", sequenceName = "SEQ_PROJECT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_PROJECT")

	private Integer id;
	
	private String wbsShortId;
	
	private String projectName;
	
	private String projectStartDate;
	
	private String projectEndDate;
	
	private String projectStaus;
	
	private String projectManager;
	
	private String deliveryProjectManager;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACT_ID")
	private Contract contract;
	
	@JsonIgnoreProperties("project")
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL )
	private List<ProjectMember> projectResources = new ArrayList<ProjectMember>();
	
	@JsonIgnoreProperties("project")
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL )
	private List<WbsElement> wbsElements = new ArrayList<WbsElement>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectStaus() {
		return projectStaus;
	}

	public void setProjectStaus(String projectStaus) {
		this.projectStaus = projectStaus;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getDeliveryProjectManager() {
		return deliveryProjectManager;
	}

	public void setDeliveryProjectManager(String deliveryProjectManager) {
		this.deliveryProjectManager = deliveryProjectManager;
	}
	
	

	public String getWbsShortId() {
		return wbsShortId;
	}

	public void setWbsShortId(String wbsShortId) {
		this.wbsShortId = wbsShortId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<ProjectMember> getProjectResources() {
		return projectResources;
	}

	public void setProjectResources(List<ProjectMember> projectResources) {
		this.projectResources = projectResources;
	}
	
	

	public List<WbsElement> getWbsElements() {
		return wbsElements;
	}

	public void setWbsElements(List<WbsElement> wbsElements) {
		this.wbsElements = wbsElements;
	}


	
	public Project(){
		
	}
	
	public Project(Integer id){
		super();
		this.id = id;
	}

	public Project(Integer id, String projectCode, String projectName, String projectStartDate, String projectEndDate,
			String projectStaus, String projectManager, String deliveryProjectManager) {
		super();
		this.id = id;
		this.wbsShortId = projectCode;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectStaus = projectStaus;
		this.projectManager = projectManager;
		this.deliveryProjectManager = deliveryProjectManager;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectCode=" + wbsShortId + ", projectName=" + projectName
				+ ", projectManager=" + projectManager + ", deliveryProjectManager=" + deliveryProjectManager + "]";
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project )) return false;
        return id != null && id.equals(((Project) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	
	

	


	
}
