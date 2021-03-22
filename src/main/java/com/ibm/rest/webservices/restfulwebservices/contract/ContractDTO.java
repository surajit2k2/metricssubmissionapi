package com.ibm.rest.webservices.restfulwebservices.contract;

import java.time.LocalDate;

import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;



public class ContractDTO {


	private Integer id;


	private String contractCode;

	private String contractOwner;


	private SubGroupDTO subGroup;



	private LocalDate contractStartDate;


	private LocalDate contractEndDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractOwner() {
		return contractOwner;
	}

	public void setContractOwner(String contractOwner) {
		this.contractOwner = contractOwner;
	}

	public SubGroupDTO getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(SubGroupDTO subGroup) {
		this.subGroup = subGroup;
	}



	public LocalDate getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public LocalDate getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public ContractDTO() {

	}

	public ContractDTO(Integer id) {
		super();
		this.id = id;
	}

	public ContractDTO(Integer id, String contractCode, String contractOwner, LocalDate contractStartDate,
			LocalDate contractEndDate) {
		super();
		this.id = id;
		this.contractCode = contractCode;
		this.contractOwner = contractOwner;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", contractCode=" + contractCode + ", contractOwner=" + contractOwner
				+ ", contractStartDate=" + contractStartDate + ", contractEndDate=" + contractEndDate + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ContractDTO))
			return false;
		return id != null && id.equals(((ContractDTO) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
