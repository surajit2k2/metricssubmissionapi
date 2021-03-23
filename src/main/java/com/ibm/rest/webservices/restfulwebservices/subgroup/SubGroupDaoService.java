package com.ibm.rest.webservices.restfulwebservices.subgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;
import com.ibm.rest.webservices.restfulwebservices.region.Region;
import com.ibm.rest.webservices.restfulwebservices.region.RegionDTO;

@Service
public class SubGroupDaoService {
	

	@Autowired
	private SubGroupRepository repository;
	
	public List<SubGroupDTO> findAll() {
		
		List<SubGroupDTO> subGroupDTOList;
		subGroupDTOList = Converter.covertToSubGroupDTOList(repository.findAll());
		return subGroupDTOList;
		
	}
	
	public Optional<SubGroupDTO> findSubGroupByName(String subGroupName) {
		
		Optional<SubGroupDTO> ret = Optional.empty();
		if(null != subGroupName){
			ret= Optional.ofNullable(Converter.covertToSubGroupDTO(repository.findBySubGroupName(subGroupName)));
		}
		return ret;
	}
	
	public List<SubGroupDTO> findSubGroupByRegionId(Integer regionId) {
		List<SubGroupDTO> ret = new ArrayList<SubGroupDTO>() ;
		if(regionId > 0){
			ret= Converter.covertToSubGroupDTOList(repository.findByRegionId(regionId));
		}
		return ret;
	}
	
	public Optional<SubGroupDTO> findById(int id) {
		Optional<SubGroupDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToSubGroupDTO(repository.findById(id).get()));
		}		
		return ret;
	}

	public Optional<SubGroupDTO> add(SubGroupDTO subGroupDTO) {
		Optional<SubGroupDTO> retSubGroupDTO= Optional.empty();
		if(subGroupDTO.getId() == null || subGroupDTO.getId() ==0){
			System.out.println("Before Insert :: " + subGroupDTO.toString());
			retSubGroupDTO= Optional.ofNullable(Converter.covertToSubGroupDTO(repository.findBySubGroupName(subGroupDTO.getSubGroupName())));
			System.out.println("Value Received from DB" + retSubGroupDTO.toString());
			if( (retSubGroupDTO.get().getId() == null)){
				System.out.println("Inserting into Database" + retSubGroupDTO.toString());
				retSubGroupDTO = Optional.ofNullable(Converter.covertToSubGroupDTO(repository.save(Converter.covertToSubGroup(subGroupDTO))));
			}
			else{
				System.out.println("Value exists into Database" + subGroupDTO.toString());
			}
		}
		else{
			retSubGroupDTO =  Optional.ofNullable(Converter.covertToSubGroupDTO(repository.save(Converter.covertToSubGroup(subGroupDTO))));
		}
		
		return retSubGroupDTO;
	}
	
	public Optional<SubGroupDTO> update(SubGroupDTO subGroupDTO) {
		Optional<SubGroupDTO> retSubGroup= Optional.empty();
		retSubGroup = Optional.ofNullable(Converter.covertToSubGroupDTO(repository.save(Converter.covertToSubGroup(subGroupDTO))));
		return retSubGroup;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
