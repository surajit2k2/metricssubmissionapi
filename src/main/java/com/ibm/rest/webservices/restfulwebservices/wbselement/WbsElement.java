package com.ibm.rest.webservices.restfulwebservices.wbselement;

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
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="WBS_ELEMENT")
public class WbsElement {

	@Id
	@Column(name = "WBS_ELEMENT_ID")
	@SequenceGenerator(name = "SEQ_WBSELEMENT", sequenceName = "SEQ_WBSELEMENT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_WBSELEMENT")
	private Integer id;

	@Column(name = "WBS_ELEMENT_NAME", nullable = false, unique = true)
	private String wbsElementName;
	
	private String wbsElementStartDate;
	
	private String wbsElementEndDate;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;
	
	@JsonIgnoreProperties("wbsElement")
	@OneToMany(mappedBy = "wbsElement", cascade = CascadeType.ALL )
	private List<ProjectMember> projectResources = new ArrayList<ProjectMember>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	

	public String getWbsElementName() {
		return wbsElementName;
	}

	public void setWbsElementName(String wbsElementName) {
		this.wbsElementName = wbsElementName;
	}

	public String getWbsElementStartDate() {
		return wbsElementStartDate;
	}

	public void setWbsElementStartDate(String wbsElementStartDate) {
		this.wbsElementStartDate = wbsElementStartDate;
	}

	public String getWbsElementEndDate() {
		return wbsElementEndDate;
	}

	public void setWbsElementEndDate(String wbsElementEndDate) {
		this.wbsElementEndDate = wbsElementEndDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<ProjectMember> getProjectResources() {
		return projectResources;
	}

	public void setProjectResources(List<ProjectMember> projectResources) {
		this.projectResources = projectResources;
	}

	
	
	public WbsElement(){
		
	}
	
	public WbsElement(Integer id){
		super();
		this.id = id;
	}

	

	public WbsElement(Integer id, String wbsElementName, String wbsElementStartDate, String wbsElementEndDate) {
		super();
		this.id = id;
		this.wbsElementName = wbsElementName;
		this.wbsElementStartDate = wbsElementStartDate;
		this.wbsElementEndDate = wbsElementEndDate;
	}

	

	
	@Override
	public String toString() {
		return "WbsElement [id=" + id + ", wbsElementName=" + wbsElementName + ", wbsElementStartDate="
				+ wbsElementStartDate + ", wbsElementEndDate=" + wbsElementEndDate + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WbsElement )) return false;
        return id != null && id.equals(((WbsElement) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	
	

	


	
}
