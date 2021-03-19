package com.ibm.rest.webservices.restfulwebservices.weeklycycle;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.rest.webservices.restfulwebservices.LocalDateDeserializer;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Table(name="WEEKLYCYCLE")
public class WeeklyCycle {

	@Id
	@Column(name = "WEEKLYCYCLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate  weekEnding;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICECYCLE_ID")
	private InvoiceCycle invoiceCycle;

	public WeeklyCycle() {

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getWeekEnding() {
		return weekEnding;
	}


	public void setWeekEnding(LocalDate weekEnding) {
		this.weekEnding = weekEnding;
	}


	public InvoiceCycle getInvoiceCycle() {
		return invoiceCycle;
	}


	public void setInvoiceCycle(InvoiceCycle invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}


	public WeeklyCycle(Integer id, LocalDate weekEnding, InvoiceCycle invoiceCycle) {
		super();
		this.id = id;
		this.weekEnding = weekEnding;
		this.invoiceCycle = invoiceCycle;
	}


	public WeeklyCycle(Integer id) {
		super();
		this.id = id;
	}


	@Override
	public String toString() {
		return "WeeklyCycle [id=" + id + ", weekEnding=" + weekEnding + ", invoiceCycle=" + invoiceCycle + "]";
	}


	

	


	
}
