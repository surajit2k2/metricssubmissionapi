package com.ibm.rest.webservices.restfulwebservices.ratechart;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="RATECHART")
public class RateChart {

	@Id
	@Column(name = "RATECHART_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer year;

	@Size(max=3, message="Rate Desc")
	private String ratecode;
	
	
	private Integer billcode;
	
	
	private double billrate;
	
	@Size(max=50, message="Rate Info")
	private String info;

	@JsonIgnoreProperties("rateChart")
	@OneToMany(mappedBy = "rateChart", cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
	private List<ProjectMember> projectResources = new ArrayList<ProjectMember>();
	
	

	public RateChart() {

	}

	

	public RateChart(Integer id, Integer year, @Size(max = 3, message = "Rate Desc") String desc, Integer billcode,
			double billrate, String info) {
		super();
		this.id = id;
		this.year = year;
		this.ratecode = desc;
		this.billcode = billcode;
		this.billrate = billrate;
		this.info = info;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public String getDesc() {
		return ratecode;
	}



	public void setDesc(String desc) {
		this.ratecode = desc;
	}



	public Integer getBillcode() {
		return billcode;
	}



	public void setBillcode(Integer billcode) {
		this.billcode = billcode;
	}



	public double getBillrate() {
		return billrate;
	}



	public void setBillrate(double billrate) {
		this.billrate = billrate;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	@Override
	public String toString() {
		return "RateChart [id=" + id + ", year=" + year + ", desc=" + ratecode + ", billrate=" + billrate + "]";
	}



	public String getRatecode() {
		return ratecode;
	}



	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}



	public List<ProjectMember> getProjectResources() {
		return projectResources;
	}



	public void setProjectResources(List<ProjectMember> projectResources) {
		this.projectResources = projectResources;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateChart )) return false;
        return id != null && id.equals(((RateChart) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

	
}
