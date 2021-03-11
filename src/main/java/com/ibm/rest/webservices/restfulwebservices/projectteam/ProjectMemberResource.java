package com.ibm.rest.webservices.restfulwebservices.projectteam;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycleDTO;
import com.ibm.rest.webservices.restfulwebservices.project.ProjectDTO;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChartDTO;
import com.ibm.rest.webservices.restfulwebservices.resource.ResourceDTO;

@RestController
@RequestMapping("/projectmember")

public class ProjectMemberResource {

	@Autowired
	ProjectMemberDaoService service;

	@GetMapping("/findallprojectbooking")
	public List<ProjectMemberDTO> retrieveAllProjectMember() {
		return service.findAll();
	}
	

	@GetMapping("/findprojectbookingbyweekandprojectcode/{weekNumber}/{projectCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByWeekAndCode(@PathVariable Integer weekNumber, @PathVariable String projectCode) {
		List<ProjectMemberDTO> ret = service.findByWeekNumberAndProjectProjectCode(weekNumber,projectCode);		
		return ret;
	}
	
	
	@GetMapping("/findprojectbookingbymonthandprojectcode/{invoiceMonth}/{projectCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByMonthAndCode(@PathVariable String invoiceMonth, @PathVariable String projectCode) {
		List<ProjectMemberDTO> ret = service.findByInvoiceCycleMonthAndProjectProjectCode(invoiceMonth,projectCode);		
		return ret;
	}
	
			
	@GetMapping("/findprojectbookingbyweekandempcode/{weekNumber}/{employeeCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByWeekAndEmployee(@PathVariable Integer weekNumber, @PathVariable String employeeCode) {
		List<ProjectMemberDTO> ret = service.findByWeekNumberAndResourceEmployeeCode(weekNumber,employeeCode);		
		return ret;
	}
	
		
	@GetMapping("/findprojectbookingbymonthandempcode/{invoiceMonth}/{employeeCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByMonthAndEmployee(@PathVariable String invoiceMonth, @PathVariable String employeeCode) {
		List<ProjectMemberDTO> ret = service.findByInvoiceCycleMonthAndResourceEmployeeCode(invoiceMonth,employeeCode);		
		return ret;
	}
	
		
	@GetMapping("/findprojectbookingbyweekandprojectandempcode/{weekNumber}/{projectCode}/{employeeCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByWeekAndProjectAndEmployee(@PathVariable Integer weekNumber, @PathVariable String projectCode, @PathVariable String employeeCode) {
		List<ProjectMemberDTO> ret = service.findByWeekNumberAndProjectProjectCodeAndResourceEmployeeCode(weekNumber, projectCode,employeeCode);		
		return ret;
	}
	
	
	@GetMapping("/findprojectbookingbymonthandprojectandempcode/{invoiceMonth}/{projectCode}/{employeeCode}")
	public List<ProjectMemberDTO> retrieveProjectBookingByMonthAndProjectAndEmployee(@PathVariable String invoiceMonth, @PathVariable String projectCode, @PathVariable String employeeCode) {
		List<ProjectMemberDTO> ret = service.findByInvoiceCycleMonthAndProjectProjectCodeAndResourceEmployeeCode(invoiceMonth, projectCode,employeeCode);		
		return ret;
	}
	

	@DeleteMapping("/deleteoneprojectbooking/{id}")
	public void deleteOneProject(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping("/addoneprojectbooking")
	public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectMemberDTO projectMemberDTO) {
		
		ProjectDTO projectDTO = new ProjectDTO(projectMemberDTO.getProject().getId());
		ResourceDTO resourceDTO = new ResourceDTO(projectMemberDTO.getResource().getId());
		InvoiceCycleDTO invoiceCycleDTO = new InvoiceCycleDTO(projectMemberDTO.getInvoiceCycle().getId());
		RateChartDTO rateChartDTO = new RateChartDTO(projectMemberDTO.getInvoiceCycle().getId());
		
		
		projectMemberDTO.setProject(projectDTO);
		projectMemberDTO.setResource(resourceDTO);
		projectMemberDTO.setInvoiceCycle(invoiceCycleDTO);
		projectMemberDTO.setRateChart(rateChartDTO);
		
		Optional<ProjectMemberDTO> savedProjectMemberDTO = service.add(projectMemberDTO);
		if(savedProjectMemberDTO.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProjectMemberDTO.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
