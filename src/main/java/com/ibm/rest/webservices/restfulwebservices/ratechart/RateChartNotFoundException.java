package com.ibm.rest.webservices.restfulwebservices.ratechart;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RateChartNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RateChartNotFoundException(){
		
	}
			
	public RateChartNotFoundException(String message) {
		super(message);
	}
}
