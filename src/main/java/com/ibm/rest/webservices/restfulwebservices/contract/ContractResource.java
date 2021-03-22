package com.ibm.rest.webservices.restfulwebservices.contract;

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
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contract")

public class ContractResource {

	@Autowired
	ContractDaoService service;

	@GetMapping("/findallcontract")
	public List<ContractDTO> retrieveAllContract() {
		//return service.findAll();
		return service.findAll();
	}
	
	@GetMapping("/findcontractbycode/{contractCode}")
	public Optional<ContractDTO> retrieveSubGroupByName(@PathVariable String contractCode) {
		Optional<ContractDTO> contractDTO = service.findContractByCode(contractCode);
		if(contractDTO.isPresent()==false){
			throw new ContractNotFoundException("Contract is not available for for name ::"+ contractCode);
		}		
		return contractDTO;
	}
	
	@GetMapping("/findcontractbysubgroupname/{subgroupname}")
	public List<ContractDTO> retrieveAllContractBySubGroupName(@PathVariable String subgroupname) {
		return service.findContractBySubGroupName(subgroupname);
	}
	
	@GetMapping("/findcontractbyregionid/{regionid}")
	public List<ContractDTO> retrieveAllContractByRegionId(@PathVariable Integer regionid) {
		return service.findContractByRegionId(regionid);
	}
	
	@GetMapping("/findcontractbysubregionname/{regionname}")
	public List<ContractDTO> retrieveAllContractByRegionName(@PathVariable String regionname) {
		return service.findContractByRegionName(regionname);
	}
	
	@GetMapping("/findcontractbysubgroupid/{subgroupid}")
	public List<ContractDTO> retrieveAllContractBySubGroup(@PathVariable Integer subgroupid) {
		return service.findContractBySubGroupId(subgroupid);
	}
	

	@GetMapping("/findonecontract/{id}")
	public Optional<ContractDTO> retrieveOneContract(@PathVariable int id) {
		Optional<ContractDTO> contractDTO = service.findById(id);
		
		if(contractDTO.isPresent()==false){
			throw new ContractNotFoundException("Contract is not available for for id ::"+ id);
		}	
		return contractDTO;
	}

	@DeleteMapping("/deleteonesubgroup/{id}")
	public void deleteOneSubGroup(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping("/addonecontract/{subgroupid}")
	public ResponseEntity<Object> createContract(@PathVariable int subgroupid,@RequestBody ContractDTO contractDTO) {
		System.out.println("contractDTO :: " + contractDTO.toString());
		SubGroupDTO saveSubGroup = new SubGroupDTO(subgroupid,"");
		contractDTO.setSubGroup(saveSubGroup);
		Optional<ContractDTO> savedContract = service.add(contractDTO);
		if(savedContract.isPresent() == true){
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedContract.get().getId())
				.toUri();

			return ResponseEntity.created(location).build();
		}else{
			return ResponseEntity.notFound().build();
		}
		

	}
}
