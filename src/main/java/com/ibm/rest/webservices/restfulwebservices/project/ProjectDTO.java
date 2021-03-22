package com.ibm.rest.webservices.restfulwebservices.project;

import com.ibm.rest.webservices.restfulwebservices.contract.ContractDTO;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;


public class ProjectDTO {


	private Integer id;
	
	private String wbsShortId;
	
	private String projectName;
	
	private String projectStartDate;
	
	private String projectEndDate;
	
	private String projectStaus;
	
	private String projectManager;
	
	private String deliveryProjectManager;
	

	private ContractDTO contract;
	
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
	
	


	

	public ContractDTO getContractDTO() {
		return contract;
	}

	public void setContractDTO(ContractDTO contract) {
		this.contract = contract;
	}

	public ProjectDTO(Integer id, String projectCode, String projectName, String projectStartDate, String projectEndDate,
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
	
	public ProjectDTO(){
		
	}
	
	public ProjectDTO(Integer id){
		super();
		this.id = id;
	}



	@Override
	public String toString() {
		return "Project [id=" + id + ", projectCode=" + wbsShortId + ", projectName=" + projectName
				+ ", projectManager=" + projectManager + ", deliveryProjectManager=" + deliveryProjectManager + "]";
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDTO )) return false;
        return id != null && id.equals(((ProjectDTO) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	
	

	


	
}
