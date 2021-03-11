package com.ibm.rest.webservices.restfulwebservices.subgroup;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubGroupNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SubGroupNotFoundException(){
		
	}
			
	public SubGroupNotFoundException(String message) {
		super(message);
	}
}
