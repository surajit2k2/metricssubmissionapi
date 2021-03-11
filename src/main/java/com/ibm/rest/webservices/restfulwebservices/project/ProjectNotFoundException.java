package com.ibm.rest.webservices.restfulwebservices.project;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProjectNotFoundException(){
		
	}
			
	public ProjectNotFoundException(String message) {
		super(message);
	}
}
