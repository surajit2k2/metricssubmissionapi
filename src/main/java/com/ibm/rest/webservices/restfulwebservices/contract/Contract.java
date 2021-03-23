package com.ibm.rest.webservices.restfulwebservices.contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.rest.webservices.restfulwebservices.LocalDateDeserializer;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name = "CONTRACT")

public class Contract {

	@Id
	@Column(name = "CONTRACT_ID")
	@SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQ_CONTRACT")
	
	private Integer id;

	@Column(name = "CONTRACT_CODE", nullable = false, unique = true)
	private String contractCode;

	private String contractOwner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBGROUP_ID")
	private SubGroup subGroup;

	@JsonIgnoreProperties("contract")
	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)

	private List<Project> project = new ArrayList<Project>();

	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate contractStartDate;

	@JsonDeserialize(using = LocalDateDeserializer.class)
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

	public SubGroup getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(SubGroup subGroup) {
		this.subGroup = subGroup;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
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

	public Contract() {

	}

	public Contract(Integer id) {
		super();
		this.id = id;
	}

	public Contract(Integer id, String contractCode, String contractOwner, LocalDate contractStartDate,
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
		if (!(o instanceof Contract))
			return false;
		return id != null && id.equals(((Contract) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
