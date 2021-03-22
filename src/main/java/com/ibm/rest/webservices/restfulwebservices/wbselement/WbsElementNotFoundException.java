package com.ibm.rest.webservices.restfulwebservices.wbselement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WbsElementNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WbsElementNotFoundException(){
		
	}
			
	public WbsElementNotFoundException(String message) {
		super(message);
	}
}
