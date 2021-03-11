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
@Table(name="SITEHOLIDAY")
public class SiteHoliday {

	@Id
	@Column(name = "SITE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "SITE_CODE")
	private String siteCode;
	
	private Integer year;
	
	private Date leaveDate1;
	private Date leaveDate2;
	private Date leaveDate3;
	private Date leaveDate4;
	private Date leaveDate5;
	private Date leaveDate6;
	private Date leaveDate7;
	private Date leaveDate8;
	private Date leaveDate9;
	private Date leaveDate10;
	private Date leaveDate11;
	private Date leaveDate12;
	private Date leaveDate13;
	private Date leaveDate14;
	private Date leaveDate15;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Date getLeaveDate1() {
		return leaveDate1;
	}
	public void setLeaveDate1(Date leaveDate1) {
		this.leaveDate1 = leaveDate1;
	}
	public Date getLeaveDate2() {
		return leaveDate2;
	}
	public void setLeaveDate2(Date leaveDate2) {
		this.leaveDate2 = leaveDate2;
	}
	public Date getLeaveDate3() {
		return leaveDate3;
	}
	public void setLeaveDate3(Date leaveDate3) {
		this.leaveDate3 = leaveDate3;
	}
	public Date getLeaveDate4() {
		return leaveDate4;
	}
	public void setLeaveDate4(Date leaveDate4) {
		this.leaveDate4 = leaveDate4;
	}
	public Date getLeaveDate5() {
		return leaveDate5;
	}
	public void setLeaveDate5(Date leaveDate5) {
		this.leaveDate5 = leaveDate5;
	}
	public Date getLeaveDate6() {
		return leaveDate6;
	}
	public void setLeaveDate6(Date leaveDate6) {
		this.leaveDate6 = leaveDate6;
	}
	public Date getLeaveDate7() {
		return leaveDate7;
	}
	public void setLeaveDate7(Date leaveDate7) {
		this.leaveDate7 = leaveDate7;
	}
	public Date getLeaveDate8() {
		return leaveDate8;
	}
	public void setLeaveDate8(Date leaveDate8) {
		this.leaveDate8 = leaveDate8;
	}
	public Date getLeaveDate9() {
		return leaveDate9;
	}
	public void setLeaveDate9(Date leaveDate9) {
		this.leaveDate9 = leaveDate9;
	}
	public Date getLeaveDate10() {
		return leaveDate10;
	}
	public void setLeaveDate10(Date leaveDate10) {
		this.leaveDate10 = leaveDate10;
	}
	public Date getLeaveDate11() {
		return leaveDate11;
	}
	public void setLeaveDate11(Date leaveDate11) {
		this.leaveDate11 = leaveDate11;
	}
	public Date getLeaveDate12() {
		return leaveDate12;
	}
	public void setLeaveDate12(Date leaveDate12) {
		this.leaveDate12 = leaveDate12;
	}
	public Date getLeaveDate13() {
		return leaveDate13;
	}
	public void setLeaveDate13(Date leaveDate13) {
		this.leaveDate13 = leaveDate13;
	}
	public Date getLeaveDate14() {
		return leaveDate14;
	}
	public void setLeaveDate14(Date leaveDate14) {
		this.leaveDate14 = leaveDate14;
	}
	public Date getLeaveDate15() {
		return leaveDate15;
	}
	public void setLeaveDate15(Date leaveDate15) {
		this.leaveDate15 = leaveDate15;
	}
	
	
	
	public SiteHoliday() {
		super();
	}
	public SiteHoliday(Integer id, String siteCode, Integer year, Date leaveDate1, Date leaveDate2, Date leaveDate3,
			Date leaveDate4, Date leaveDate5, Date leaveDate6, Date leaveDate7, Date leaveDate8, Date leaveDate9,
			Date leaveDate10, Date leaveDate11, Date leaveDate12, Date leaveDate13, Date leaveDate14,
			Date leaveDate15) {
		super();
		this.id = id;
		this.siteCode = siteCode;
		this.year = year;
		this.leaveDate1 = leaveDate1;
		this.leaveDate2 = leaveDate2;
		this.leaveDate3 = leaveDate3;
		this.leaveDate4 = leaveDate4;
		this.leaveDate5 = leaveDate5;
		this.leaveDate6 = leaveDate6;
		this.leaveDate7 = leaveDate7;
		this.leaveDate8 = leaveDate8;
		this.leaveDate9 = leaveDate9;
		this.leaveDate10 = leaveDate10;
		this.leaveDate11 = leaveDate11;
		this.leaveDate12 = leaveDate12;
		this.leaveDate13 = leaveDate13;
		this.leaveDate14 = leaveDate14;
		this.leaveDate15 = leaveDate15;
	}
	@Override
	public String toString() {
		return "SiteHoliday [id=" + id + ", siteCode=" + siteCode + ", year=" + year + ", leaveDate1=" + leaveDate1
				+ ", leaveDate2=" + leaveDate2 + ", leaveDate3=" + leaveDate3 + ", leaveDate4=" + leaveDate4
				+ ", leaveDate5=" + leaveDate5 + ", leaveDate6=" + leaveDate6 + ", leaveDate7=" + leaveDate7
				+ ", leaveDate8=" + leaveDate8 + ", leaveDate9=" + leaveDate9 + ", leaveDate10=" + leaveDate10 + "]";
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SiteHoliday )) return false;
        return id != null && id.equals(((SiteHoliday) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	


	
}
