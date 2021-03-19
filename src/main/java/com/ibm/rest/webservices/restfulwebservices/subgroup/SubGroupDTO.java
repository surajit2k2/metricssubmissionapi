package com.ibm.rest.webservices.restfulwebservices.subgroup;

import com.ibm.rest.webservices.restfulwebservices.region.RegionDTO;

public class SubGroupDTO {


	private Integer id;

	private String subGroupName;


	private RegionDTO region;


	public SubGroupDTO() {

	}

	
	
	public SubGroupDTO(Integer id, String subGroupName, RegionDTO region) {
		super();
		this.id = id;
		this.subGroupName = subGroupName;
		this.region = region;
	}

	

	public SubGroupDTO(Integer id, String subGroupName) {
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

	public RegionDTO getRegion() {
		return region;
	}

	public void setRegion(RegionDTO region) {
		this.region = region;
	}



	@Override
	public String toString() {
		return "SubGroup [id=" + id + ", subGroupName=" + subGroupName + "]";
	}



	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SubGroupDTO))
			return false;
		return id != null && id.equals(((SubGroupDTO) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
