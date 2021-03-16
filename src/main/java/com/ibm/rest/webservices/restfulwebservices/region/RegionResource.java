package com.ibm.rest.webservices.restfulwebservices.region;

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
@RequestMapping("/region")

public class RegionResource {

	@Autowired
	RegionDaoService service;

	@GetMapping("/findallregion")
	public List<RegionDTO> retrieveAllRegion() {
		return service.findAll();
	}
	
	@GetMapping("/findregionbyname/{regionName}")
	public Optional<RegionDTO> retrieveRegionByName(@PathVariable String regionName) {
		Optional<RegionDTO> region = service.findRegionByName(regionName);
		if(region.isPresent()==false){
			throw new RegionNotFoundException("Region is not available for for name ::"+ regionName);
		}
		
		return region;
	}

	@GetMapping("/findoneregion/{id}")
	public EntityModel<Optional<RegionDTO>> retrieveOneRateChart(@PathVariable int id) {
		Optional<RegionDTO> region = service.findById(id);
		
		if(region.isPresent()==false){
			throw new RegionNotFoundException("Region is not available for for id ::"+ id);
		}
	
		EntityModel<Optional<RegionDTO>> resource = EntityModel.of(region);
		
		WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllRegion());
		
		resource.add(linkTo.withRel("all-region"));
		
		//HATEOAS
		
		return resource;
	}

	@DeleteMapping("/deleteoneregion/{id}")
	public void deleteOneRegion(@PathVariable int id) {
		service.deleteById(id);
	}



	@PostMapping("/addoneregion")
	public ResponseEntity<Object> createRegion(@Valid @RequestBody RegionDTO region) {
		Optional<RegionDTO> savedRegion = service.save(region);
		if(savedRegion.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRegion.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
