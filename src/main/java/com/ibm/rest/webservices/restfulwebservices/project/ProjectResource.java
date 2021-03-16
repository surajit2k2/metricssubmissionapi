package com.ibm.rest.webservices.restfulwebservices.project;

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

import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")

public class ProjectResource {

	@Autowired
	ProjectDaoService service;

	@GetMapping("/findallproject")
	public List<ProjectDTO> retrieveAllProject() {
		return service.findAll();
	}
	
	@GetMapping("/findprojectbyname/{projectName}")
	public List<ProjectDTO> retrieveProjectByName(@PathVariable String projectName) {
		List<ProjectDTO> project = service.findByProjectName(projectName);		
		return project;
	}
	
	@GetMapping("/findprojectbycode/{projectCode}")
	public List<ProjectDTO> retrieveProjectByCode(@PathVariable String projectCode) {
		List<ProjectDTO> project = service.findByProjectCode(projectCode);		
		return project;
	}
	
	@GetMapping("/findprojectbysubgroupid/{subGroupId}")
	public List<ProjectDTO> retrieveProjectBySubGroupId(@PathVariable Integer subGroupId) {
		List<ProjectDTO> project = service.findBySubGroupId(subGroupId);		
		return project;
	}
	
	@GetMapping("/findprojectbysubgroupname/{subGroupName}")
	public List<ProjectDTO> retrieveProjectBySubGroupName(@PathVariable String subGroupName) {
		List<ProjectDTO> project = service.findBySubGroupName(subGroupName);		
		return project;
	}
	

	@GetMapping("/findoneproject/{projectid}")
	public Optional<ProjectDTO> retrieveOneSubGroup(@PathVariable int projectid) {
		Optional<ProjectDTO> project = service.findById(projectid);
		
		if(project.isPresent()==false){
			throw new ProjectNotFoundException("SubGroup is not available for for id ::"+ projectid);
		}	
		return project;
	}

	@DeleteMapping("/deleteoneproject/{id}")
	public void deleteOneProject(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping("/addoneproject/{subGroupId}")
	public ResponseEntity<Object> createProject(@PathVariable int subGroupId,@Valid @RequestBody ProjectDTO projectDTO) {
		SubGroupDTO saveSubGroupDTO = new SubGroupDTO(subGroupId,"");
		
		projectDTO.setSubGroup(saveSubGroupDTO);
		Optional<ProjectDTO> savedProject = service.add(projectDTO);
		if(savedProject.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProject.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
