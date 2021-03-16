package com.ibm.rest.webservices.restfulwebservices.weeklycycle;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycleDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/weeklycycle")

public class WeeklyCycleResource {

	@Autowired
	WeeklyCycleDaoService service;

	@GetMapping("/findallweeklycycle")
	public List<WeeklyCycleDTO> retrieveAllWeeklyCycle() {
		return service.findAll();
	}
	
	@GetMapping("/findweeklycyclebyyear/{year}")
	public List<WeeklyCycleDTO> retrieveWeeklyCycleYearly(@PathVariable int year) {
		return service.findByYear(year);
	}
	
	@GetMapping("/findweeklycyclebymonth/{month}")
	public List<WeeklyCycleDTO> retrieveWeeklyCycleMonthly(@PathVariable String month ) {
		return service.findByMonth( month);
	}
	
	@GetMapping("/findweeklycyclebyyearandmonth/{year}/{month}")
	public List<WeeklyCycleDTO> retrieveWeeklyCycleYearlyAndMonthly(@PathVariable int year,@PathVariable String month ) {
		return service.findByYearAndMonth(year, month);
	}
	

	@GetMapping("/findoneweeklycycle/{id}")
	public EntityModel<Optional<WeeklyCycleDTO>> retrieveOneWeeklyCycle(@PathVariable int id) {
		Optional<WeeklyCycleDTO> weeklyCycleDTO = service.findById(id);
		
		if(weeklyCycleDTO.isPresent()==false){
			throw new WeeklyCycleNotFoundException("Weeklycycle is not available for for id ::"+ id);
		}
	
		EntityModel<Optional<WeeklyCycleDTO>> resource = EntityModel.of(weeklyCycleDTO);
		
		WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllWeeklyCycle());
		
		resource.add(linkTo.withRel("all-weekly-cycle"));
			
		return resource;
	}

	@DeleteMapping("/deleteoneinvoicecycle/{id}")
	public void deleteOneInvoiceCycle(@PathVariable int id) {
		service.deleteById(id);
	}

	
	// HATEOAS

	@PostMapping("/addoneweekcycle/{invoiceId}")
	public ResponseEntity<Object> createInvoiceCycle(@PathVariable int invoiceId,@Valid @RequestBody WeeklyCycleDTO weeklyCycleDTO) {
		InvoiceCycleDTO saveInvoiceCycle = new InvoiceCycleDTO(invoiceId);
		weeklyCycleDTO.setInvoiceCycle(saveInvoiceCycle); 
		
		Optional<WeeklyCycleDTO> savedWeeklyCycleDTO = service.save(weeklyCycleDTO);
		if(savedWeeklyCycleDTO.isPresent() == true){
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedWeeklyCycleDTO.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
	}
}
