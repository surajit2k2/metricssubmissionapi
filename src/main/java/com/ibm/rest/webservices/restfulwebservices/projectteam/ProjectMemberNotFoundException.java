package com.ibm.rest.webservices.restfulwebservices.projectteam;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectMemberNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProjectMemberNotFoundException(){
		
	}
			
	public ProjectMemberNotFoundException(String message) {
		super(message);
	}
}
