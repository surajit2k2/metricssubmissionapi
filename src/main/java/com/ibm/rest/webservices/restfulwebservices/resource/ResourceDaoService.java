package com.ibm.rest.webservices.restfulwebservices.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class ResourceDaoService {
	

	@Autowired
	private ResourceRepository repository;
	
	public List<ResourceDTO> findAll() {
		List<ResourceDTO> resourceDTOList;
		resourceDTOList = Converter.covertToResourceDTOList(repository.findAll());
		return resourceDTOList;		
	}
	
	public List<ResourceDTO> findByEmployeeName(String employeeName) {
		List<ResourceDTO> ret = new ArrayList<ResourceDTO>();
		
		if(null != employeeName){
			ret= Converter.covertToResourceDTOList(repository.findByEmployeeName(employeeName));
		}
		return ret;
		
	}
	
	public List<ResourceDTO> findByEmployeeBand(String employeeBand) {
		List<ResourceDTO> ret = new ArrayList<ResourceDTO>();
		if(null != employeeBand){
			ret= Converter.covertToResourceDTOList(repository.findByEmployeeBand(employeeBand));
		}		
		return ret;
	}
	
	public List<ResourceDTO> findByWorkingPlace(String workingPlace) {
		List<ResourceDTO> ret = new ArrayList<ResourceDTO>();
		if(null != workingPlace ){
			ret= Converter.covertToResourceDTOList(repository.findByWorkingPlace(workingPlace));
		}		
		return ret;
	}
	
	public Optional<ResourceDTO> findByEmployeeCode(String employeeCode) {
		Optional<ResourceDTO> ret = Optional.empty();
		if(null != employeeCode){
			ret= Optional.ofNullable(Converter.covertToResourceDTO(repository.findByEmployeeCode(employeeCode)));
		}		
		return ret;
	}
	
	public Optional<ResourceDTO> findById(Integer id) {
		Optional<ResourceDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToResourceDTO(repository.findById(id).get()));
		}		
		return ret;
	}


	public Optional<ResourceDTO> add(ResourceDTO resourceDTO) {
		Optional<ResourceDTO> ret= Optional.empty();
		
		ret = Optional.ofNullable(Converter.covertToResourceDTO(repository.save(Converter.covertToResource(resourceDTO))));
		return ret;
	}
	
	public Optional<ResourceDTO> update(ResourceDTO resourceDTO) {
		Optional<ResourceDTO> ret= Optional.empty();
		
		ret = Optional.ofNullable(Converter.covertToResourceDTO(repository.save(Converter.covertToResource(resourceDTO))));
		return ret;
	}
	
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
