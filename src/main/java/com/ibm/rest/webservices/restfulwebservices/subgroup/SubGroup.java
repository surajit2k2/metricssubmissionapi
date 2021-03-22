package com.ibm.rest.webservices.restfulwebservices.subgroup;

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

import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.contract.Contract;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.region.Region;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name = "SUBGROUP")

public class SubGroup {

	@Id
	@Column(name = "SUBGROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "SUB_GROUP_NAME", nullable = false, unique = true)
	private String subGroupName;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@LazyGroup("region")    
	@JoinColumn(name = "REGION_ID")

	private Region region;

	@JsonIgnoreProperties("subGroup")
	@OneToMany(mappedBy = "subGroup", cascade = CascadeType.ALL)

	private List<Contract> contract = new ArrayList<Contract>();

	public SubGroup() {

	}

	
	
	public SubGroup(Integer id, String subGroupName, Region region) {
		super();
		this.id = id;
		this.subGroupName = subGroupName;
		this.region = region;
	}

	

	public SubGroup(Integer id, String subGroupName) {
		super();
		this.id = id;
		this.subGroupName = subGroupName;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "SubGroup [id=" + id + ", subGroupName=" + subGroupName + "]";
	}



	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SubGroup))
			return false;
		return id != null && id.equals(((SubGroup) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
