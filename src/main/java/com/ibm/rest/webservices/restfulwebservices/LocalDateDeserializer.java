package com.ibm.rest.webservices.restfulwebservices;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

	  @Override
	  public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
	        throws IOException, JsonProcessingException {

	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

	      LocalDate localDate = null;
	      localDate = LocalDate.parse(p.getText(), formatter);

	      return localDate;
	  }
	}
