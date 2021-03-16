package com.ibm.rest.webservices.restfulwebservices.subgroup;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.ibm.rest.webservices.restfulwebservices.region.RegionDTO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subgroup")

public class SubGroupResource {

	@Autowired
	SubGroupDaoService service;

	@GetMapping("/findallsubgroup")
	public List<SubGroupDTO> retrieveAllSubGroup() {
		//return service.findAll();
		return service.findAll();
	}
	
	@GetMapping("/findsubgroupbyname/{subgroupName}")
	public Optional<SubGroupDTO> retrieveSubGroupByName(@PathVariable String subgroupName) {
		Optional<SubGroupDTO> subGroup = service.findSubGroupByName(subgroupName);
		if(subGroup.isPresent()==false){
			throw new SubGroupNotFoundException("Region is not available for for name ::"+ subgroupName);
		}		
		return subGroup;
	}
	
	@GetMapping("/findsubgroupbyregion/{regionid}")
	public List<SubGroupDTO> retrieveAllSubGroupByRegion(@PathVariable Integer regionid) {
		return service.findSubGroupByRegionId(regionid);
	}

	@GetMapping("/findonesubgroup/{id}")
	public Optional<SubGroupDTO> retrieveOneSubGroup(@PathVariable int id) {
		Optional<SubGroupDTO> subGroup = service.findById(id);
		
		if(subGroup.isPresent()==false){
			throw new SubGroupNotFoundException("SubGroup is not available for for id ::"+ id);
		}	
		return subGroup;
	}

	@DeleteMapping("/deleteonesubgroup/{id}")
	public void deleteOneSubGroup(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping("/addonesubgroup/{regionid}")
	public ResponseEntity<Object> createRegion(@PathVariable int regionid,@RequestBody SubGroupDTO subGroupDTO) {
		RegionDTO saveRegion = new RegionDTO(regionid,"");
		subGroupDTO.setRegion(saveRegion);
		Optional<SubGroupDTO> savedSubGroup = service.add(subGroupDTO);
		if(savedSubGroup.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSubGroup.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
