package com.ibm.rest.webservices.restfulwebservices.region;

public class RegionDTO {

	private Integer id;
	
	private String regionName;
			
	public RegionDTO() {

	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public String getRegionName() {
		return regionName;
	}




	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}



	@Override
	public String toString() {
		return "Region [id=" + id + ", regionName=" + regionName + "]";
	}




	public RegionDTO(Integer id, String regionName) {
		super();
		this.id = id;
		this.regionName = regionName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegionDTO )) return false;
        return id != null && id.equals(((RegionDTO) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	

	


	
}
