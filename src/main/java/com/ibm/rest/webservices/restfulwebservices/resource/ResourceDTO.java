package com.ibm.rest.webservices.restfulwebservices.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;


public class ResourceDTO {

	@Id
	@Column(name = "RESOURCE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	private String employeeName;
	
	private String employeeCode;
	
	private String employeeBand;
	
	private String workingPlace;
	
	
	public ResourceDTO() {

	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeeCode() {
		return employeeCode;
	}



	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}



	public String getEmployeeBand() {
		return employeeBand;
	}



	public void setEmployeeBand(String employeeBand) {
		this.employeeBand = employeeBand;
	}







	

	public String getWorkingPlace() {
		return workingPlace;
	}



	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}


	public ResourceDTO(Integer id) {
		super();
		this.id = id;
	}

	public ResourceDTO(Integer id, String employeeName, String employeeCode, String employeeBand, String workingPlace) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
		this.employeeBand = employeeBand;
		this.workingPlace = workingPlace;
	}



	@Override
	public String toString() {
		return "ProjectResouces [id=" + id + ", employeeName=" + employeeName + ", employeeCode=" + employeeCode + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceDTO )) return false;
        return id != null && id.equals(((ResourceDTO) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	


	
}
