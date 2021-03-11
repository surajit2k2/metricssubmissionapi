package com.ibm.rest.webservices.restfulwebservices.invoicecycle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.rest.webservices.restfulwebservices.LocalDateDeserializer;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="INVOICECYCLE")
public class InvoiceCycle {

	@Id
	@Column(name = "INVOICECYCLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer year;
	
	private String month;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate  invoiceStartDate;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate  invoiceEndDate;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate  timeSheetDueDate;
	
	private Integer noOfWeekInCycle;
	
	private Integer weekNumber;
	
	@JsonIgnoreProperties("invoiceCycle")
	@OneToMany(mappedBy = "invoiceCycle", cascade = CascadeType.ALL )
	private List<ProjectMember> projectResources = new ArrayList<ProjectMember>();

	public InvoiceCycle() {

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


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public LocalDate getInvoiceStartDate() {
		return invoiceStartDate;
	}


	public void setInvoiceStartDate(LocalDate invoiceStartDate) {
		this.invoiceStartDate = invoiceStartDate;
	}


	public LocalDate getInvoiceEndDate() {
		return invoiceEndDate;
	}


	public void setInvoiceEndDate(LocalDate invoiceEndDate) {
		this.invoiceEndDate = invoiceEndDate;
	}


	public LocalDate getTimeSheetDueDate() {
		return timeSheetDueDate;
	}


	public void setTimeSheetDueDate(LocalDate timeSheetDueDate) {
		this.timeSheetDueDate = timeSheetDueDate;
	}


	public Integer getNoOfWeekInCycle() {
		return noOfWeekInCycle;
	}


	public void setNoOfWeekInCycle(Integer noOfWeekInCycle) {
		this.noOfWeekInCycle = noOfWeekInCycle;
	}


	public Integer getWeekNumber() {
		return weekNumber;
	}


	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	

	public InvoiceCycle(Integer id, Integer year, String month, LocalDate invoiceStartDate, LocalDate invoiceEndDate,
			LocalDate timeSheetDueDate, Integer noOfWeekInCycle, Integer weekNumber) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.invoiceStartDate = invoiceStartDate;
		this.invoiceEndDate = invoiceEndDate;
		this.timeSheetDueDate = timeSheetDueDate;
		this.noOfWeekInCycle = noOfWeekInCycle;
		this.weekNumber = weekNumber;
	}


	@Override
	public String toString() {
		return "InvoiceCycle [id=" + id + ", year=" + year + ", month=" + month + ", invoiceStartDate="
				+ invoiceStartDate + ", invoiceEndDate=" + invoiceEndDate + "]";
	}

	


	
}
