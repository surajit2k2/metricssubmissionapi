package com.ibm.rest.webservices.restfulwebservices.wbselement;

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

import com.ibm.rest.webservices.restfulwebservices.project.ProjectDTO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/wbselement")

public class WbsElementResource {

	@Autowired
	WbsElementDaoService service;

	@GetMapping("/findallwbselement")
	public List<WbsElementDTO> retrieveAllWbsElement() {
		return service.findAll();
	}
	
	@GetMapping("/findwbselementbyname/{wbselementname}")
	public Optional<WbsElementDTO> retrieveWbsElementByName(@PathVariable String wbselementname) {
		Optional<WbsElementDTO> wbselement = service.findByWbsElementName(wbselementname);		
		return wbselement;
	}
	
	@GetMapping("/findwbselementbyshortid/{shortid}")
	public List<WbsElementDTO> retrieveWbsElementByProjectCode(@PathVariable String shortid) {
		List<WbsElementDTO> wbsElementDTO = service.findByProjectWbsShortId(shortid);		
		return wbsElementDTO;
	}
	
	@GetMapping("/findwbselementbyprojectid/{projectid}")
	public List<WbsElementDTO> retrieveWbsElementByProjectCode(@PathVariable Integer projectid) {
		List<WbsElementDTO> wbsElementDTO = service.findByProjectId(projectid);		
		return wbsElementDTO;
	}
	
	
	@GetMapping("/findonewbselement/{id}")
	public Optional<WbsElementDTO> retrieveOneWbsElement(@PathVariable int id) {
		Optional<WbsElementDTO> wbsElementDTO = service.findById(id);
		
		if(wbsElementDTO.isPresent()==false){
			throw new WbsElementNotFoundException("wbsElementDTO is not available for for id ::"+ id);
		}	
		return wbsElementDTO;
	}

	@DeleteMapping("/deleteonewbselement/{id}")
	public void deleteOneProject(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping("/addonewbselement/{projectId}")
	public ResponseEntity<Object> createWbsElement(@PathVariable int projectId,@Valid @RequestBody WbsElementDTO wbsElementDTO) {
		ProjectDTO saveProjectDTO = new ProjectDTO(projectId);
		
		wbsElementDTO.setProject(saveProjectDTO);
		Optional<WbsElementDTO> savedWbsElement = service.add(wbsElementDTO);
		if(savedWbsElement.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedWbsElement.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
