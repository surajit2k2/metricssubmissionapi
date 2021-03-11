package com.ibm.rest.webservices.restfulwebservices.holidaylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;

@Entity
@Table(name="INDIVIDAULLEAVE")
public class IndividualLeave {

	@Id
	@Column(name = "LEAVE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "EMP_CODE")
	private String empCode;
	
	private Integer year;
	
	private Date appliedleaveDate;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getAppliedleaveDate() {
		return appliedleaveDate;
	}

	public void setAppliedleaveDate(Date appliedleaveDate) {
		this.appliedleaveDate = appliedleaveDate;
	}
	
	
	
	

	public IndividualLeave() {
		super();
	}

	public IndividualLeave(Integer id, String empCode, Integer year, Date appliedleaveDate) {
		super();
		this.id = id;
		this.empCode = empCode;
		this.year = year;
		this.appliedleaveDate = appliedleaveDate;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndividualLeave )) return false;
        return id != null && id.equals(((IndividualLeave) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	


	
}
