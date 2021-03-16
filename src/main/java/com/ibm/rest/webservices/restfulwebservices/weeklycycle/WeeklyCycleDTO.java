package com.ibm.rest.webservices.restfulwebservices.weeklycycle;

import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycleDTO;


public class WeeklyCycleDTO {


	private Integer id;
	
	
	private String weekEnding;
	

	private InvoiceCycleDTO invoiceCycle;

	public WeeklyCycleDTO() {

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getWeekEnding() {
		return weekEnding;
	}


	public void setWeekEnding(String weekEnding) {
		this.weekEnding = weekEnding;
	}


	public InvoiceCycleDTO getInvoiceCycle() {
		return invoiceCycle;
	}


	public void setInvoiceCycle(InvoiceCycleDTO invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}


	public WeeklyCycleDTO(Integer id, String weekEnding, InvoiceCycleDTO invoiceCycle) {
		super();
		this.id = id;
		this.weekEnding = weekEnding;
		this.invoiceCycle = invoiceCycle;
	}


	public WeeklyCycleDTO(Integer id) {
		super();
		this.id = id;
	}


	@Override
	public String toString() {
		return "WeeklyCycle [id=" + id + ", weekEnding=" + weekEnding + ", invoiceCycle=" + invoiceCycle + "]";
	}


	

	


	
}
