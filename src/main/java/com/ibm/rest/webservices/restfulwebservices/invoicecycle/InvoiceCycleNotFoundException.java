package com.ibm.rest.webservices.restfulwebservices.invoicecycle;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvoiceCycleNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvoiceCycleNotFoundException(){
		
	}
			
	public InvoiceCycleNotFoundException(String message) {
		super(message);
	}
}
