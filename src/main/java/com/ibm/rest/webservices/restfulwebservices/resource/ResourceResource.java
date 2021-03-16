package com.ibm.rest.webservices.restfulwebservices.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/resource")

public class ResourceResource {

	@Autowired
	ResourceDaoService service;

	@GetMapping("/findallresource")
	public List<ResourceDTO> retrieveAllResource() {
		return service.findAll();
	}
	
	@GetMapping("/findresourcebyemployeename/{employeeName}")
	public List<ResourceDTO> retrieveResourceByName(@PathVariable String employeeName) {
		List<ResourceDTO> resourceList = service.findByEmployeeName(employeeName);		
		return resourceList;
	}
	
	@GetMapping("/findresourcebyemployeeband/{employeeBand}")
	public List<ResourceDTO> retrieveResourceByBand(@PathVariable String employeeBand) {
		List<ResourceDTO> resourceList = service.findByEmployeeBand(employeeBand);		
		return resourceList;
	}
	
	@GetMapping("/findresourcebyworkingplace/{workingPlace}")
	public List<ResourceDTO> retrieveResourceByWorkingPlace(@PathVariable String workingPlace) {
		List<ResourceDTO> resourceList = service.findByWorkingPlace(workingPlace);		
		return resourceList;
	}
	
	@GetMapping("/findresourcebycode/{employeeCode}")
	public Optional<ResourceDTO> retrieveOneResourceByCode(@PathVariable String employeeCode) {
		Optional<ResourceDTO> resourceDTO = service.findByEmployeeCode(employeeCode);
		
		if(resourceDTO.isPresent()==false){
			throw new ResourceNotFoundException("Resource is not available for for code ::"+ employeeCode);
		}	
		return resourceDTO;
	}

	@GetMapping("/findoneresource/{resourceid}")
	public Optional<ResourceDTO> retrieveOneResource(@PathVariable int resourceid) {
		Optional<ResourceDTO> resourceDTO = service.findById(resourceid);
		
		if(resourceDTO.isPresent()==false){
			throw new ResourceNotFoundException("Resource is not available for for id ::"+ resourceid);
		}	
		return resourceDTO;
	}

	@DeleteMapping("/deleteoneresource/{id}")
	public void deleteOneResource(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PostMapping("/addoneresource")
	public ResponseEntity<Object> createResource(@Valid @RequestBody ResourceDTO resourceDTO) {
		Optional<ResourceDTO> savedResource = service.add(resourceDTO);
		if(savedResource.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedResource.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}


}
