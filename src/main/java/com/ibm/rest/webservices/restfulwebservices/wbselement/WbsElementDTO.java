package com.ibm.rest.webservices.restfulwebservices.wbselement;

import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.project.ProjectDTO;

public class WbsElementDTO {

	private Integer id;

	private String wbsElementName;

	private String wbsElementStartDate;

	private String wbsElementEndDate;

	private ProjectDTO project;

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

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public WbsElementDTO() {

	}

	public WbsElementDTO(Integer id) {
		super();
		this.id = id;
	}

	public WbsElementDTO(Integer id, String wbsElementName, String wbsElementStartDate, String wbsElementEndDate) {
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
		if (this == o)
			return true;
		if (!(o instanceof WbsElementDTO))
			return false;
		return id != null && id.equals(((WbsElementDTO) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
