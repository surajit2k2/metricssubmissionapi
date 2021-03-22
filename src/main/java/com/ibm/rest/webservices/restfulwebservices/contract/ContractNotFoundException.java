package com.ibm.rest.webservices.restfulwebservices.contract;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContractNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContractNotFoundException(){
		
	}
			
	public ContractNotFoundException(String message) {
		super(message);
	}
}
