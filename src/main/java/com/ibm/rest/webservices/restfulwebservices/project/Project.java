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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="Project")
public class Project {

	@Id
	@Column(name = "PROJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String projectCode;
	
	private String projectName;
	
	private String projectStartDate;
	
	private String projectEndDate;
	
	private String projectStaus;
	
	private String projectManager;
	
	private String deliveryProjectManager;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBGROUP_ID")
	private SubGroup subGroup;
	
	@JsonIgnoreProperties("project")
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL )
	private List<ProjectMember> projectResources = new ArrayList<ProjectMember>();
	
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
	
	

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

	public SubGroup getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(SubGroup subGroup) {
		this.subGroup = subGroup;
	}
	
	

	public List<ProjectMember> getProjectResources() {
		return projectResources;
	}

	public void setProjectResources(List<ProjectMember> projectResources) {
		this.projectResources = projectResources;
	}
	
	

	public Project(Integer id, String projectCode, String projectName, String projectStartDate, String projectEndDate,
			String projectStaus, String projectManager, String deliveryProjectManager) {
		super();
		this.id = id;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectStaus = projectStaus;
		this.projectManager = projectManager;
		this.deliveryProjectManager = deliveryProjectManager;
	}
	
	public Project(){
		
	}
	
	public Project(Integer id){
		super();
		this.id = id;
	}

	public Project(Integer id, String projectCode, String projectName, String projectStartDate, String projectEndDate,
			String projectStaus, String projectManager, String deliveryProjectManager, SubGroup subGroup) {
		super();
		this.id = id;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectStaus = projectStaus;
		this.projectManager = projectManager;
		this.deliveryProjectManager = deliveryProjectManager;
		this.subGroup = subGroup;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectCode=" + projectCode + ", projectName=" + projectName
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
