package com.ibm.rest.webservices.restfulwebservices.region;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;

@Entity
@Table(name="REGION")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"}) 
public class Region {

	@Id
	@Column(name = "REGION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "REGION_NAME", nullable = false, unique = true)
	private String regionName;
	
	@JsonIgnoreProperties("region")
	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL  ,fetch=FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private List<SubGroup> subGroup = new ArrayList<SubGroup>();
	
	public Region() {

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



	
	public List<SubGroup> getSubGroup() {
		return subGroup;
	}

	


	public void setSubGroup(List<SubGroup> subGroup) {
		this.subGroup = subGroup;
	}
	@Override
	public String toString() {
		return "Region [id=" + id + ", regionName=" + regionName + "]";
	}




	public Region(Integer id, String regionName) {
		super();
		this.id = id;
		this.regionName = regionName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region )) return false;
        return id != null && id.equals(((Region) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	

	


	
}
