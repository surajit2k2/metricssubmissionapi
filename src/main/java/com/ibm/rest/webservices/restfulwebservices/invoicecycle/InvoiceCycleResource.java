package com.ibm.rest.webservices.restfulwebservices.invoicecycle;

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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/invoicecycle")

public class InvoiceCycleResource {

	@Autowired
	InvoiceCycleDaoService service;

	@GetMapping("/findallinvoicecycle")
	public List<InvoiceCycleDTO> retrieveAllInvoiceCycle() {
		return service.findAll();
	}
	
	@GetMapping("/findinvoicecyclebyyear/{year}")
	public List<InvoiceCycleDTO> retrieveInvoiceCycleYearly(@PathVariable int year) {
		return service.findByYear(year);
	}
	
	@GetMapping("/findinvoicecyclebymonth/{month}")
	public List<InvoiceCycleDTO> retrieveInvoiceCycleMonthly(@PathVariable String month ) {
		return service.findByMonth( month);
	}
	
	@GetMapping("/findinvoicecyclebyyearandmonth/{year}/{month}")
	public List<InvoiceCycleDTO> retrieveInvoiceCycleYearlyAndMonthly(@PathVariable int year,@PathVariable String month ) {
		return service.findByYearAndMonth(year, month);
	}
	

	@GetMapping("/findoneinvoicecycle/{id}")
	public EntityModel<Optional<InvoiceCycleDTO>> retrieveOneRateChart(@PathVariable int id) {
		Optional<InvoiceCycleDTO> invoiceCycleDTO = service.findById(id);
		
		if(invoiceCycleDTO.isPresent()==false){
			throw new InvoiceCycleNotFoundException("Invoicecycle is not available for for id ::"+ id);
		}
	
		EntityModel<Optional<InvoiceCycleDTO>> resource = EntityModel.of(invoiceCycleDTO);
		
		WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllInvoiceCycle());
		
		resource.add(linkTo.withRel("all-invoice-cycle"));
		
		//HATEOAS
		
		return resource;
	}

	@DeleteMapping("/deleteoneinvoicecycle/{id}")
	public void deleteOneInvoiceCycle(@PathVariable int id) {
		service.deleteById(id);
	}

	
	// HATEOAS

	@PostMapping("/addoneinvoicecycle")
	public ResponseEntity<Object> createInvoiceCycle(@Valid @RequestBody InvoiceCycleDTO invoiceCycleDTO) {
		Optional<InvoiceCycleDTO> savedInvoiceCycleDTO = service.save(invoiceCycleDTO);
		if(savedInvoiceCycleDTO.isPresent() == true){
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedInvoiceCycleDTO.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
	}
}
