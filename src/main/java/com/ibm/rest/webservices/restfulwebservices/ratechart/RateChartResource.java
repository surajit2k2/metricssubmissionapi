package com.ibm.rest.webservices.restfulwebservices.ratechart;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/ratechart")

public class RateChartResource {

	@Autowired
	RateChartDaoService service;

	@GetMapping("/findallrates")
	public List<RateChartDTO> retrieveAllRates() {
		return service.findAll();
	}
	
	@GetMapping("/findratesyearly/{year}")
	public List<RateChartDTO> retrieveRatesYearly(@PathVariable int year) {
		return service.findByYear(year);
	}
	
	@GetMapping("/findratesyearlybycode/{year}/{ratecode}")
	public List<RateChartDTO> retrieveRatesYearlyByCode(@PathVariable int year,@PathVariable String ratecode ) {
		return service.findByYearAndRateCode(year, ratecode);
	}

	@GetMapping("/findonerate/{id}")
	public EntityModel<Optional<RateChartDTO>> retrieveOneRateChart(@PathVariable int id) {
		Optional<RateChartDTO> rateChartDTO = service.findById(id);
		
		if(rateChartDTO.isPresent()==false){
			throw new RateChartNotFoundException("RateChart is not available for for id ::"+ id);
		}
	
		EntityModel<Optional<RateChartDTO>> resource = EntityModel.of(rateChartDTO);
		
		WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllRates());
		
		resource.add(linkTo.withRel("all-rate-chart"));
		
		//HATEOAS
		
		return resource;
	}

	@DeleteMapping("/deleteonerate/{id}")
	public void deleteOneRate(@PathVariable int id) {
		service.deleteById(id);
	}

	//
	// input - details of ratechart
	// output - CREATED & Return the created URI

	// HATEOAS

	@PostMapping("/addonerate")
	public ResponseEntity<Object> createRate(@Valid @RequestBody RateChartDTO rateChartDTO) {
		Optional<RateChartDTO> savedRateChartDTO = service.save(rateChartDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRateChartDTO.get().getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
