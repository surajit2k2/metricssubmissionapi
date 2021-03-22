package com.ibm.rest.webservices.restfulwebservices.wbselement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class WbsElementDaoService {
	

	@Autowired
	private WbsElementRepository repository;
	
	public List<WbsElementDTO> findAll() {
		List<WbsElementDTO> wbsElementDTOList;
		wbsElementDTOList = Converter.covertToWbsElementDTOList(repository.findAll());
		return wbsElementDTOList;		
	}
	


	public Optional<WbsElementDTO> findByWbsElementName(String wbsElementName) {
		Optional<WbsElementDTO> ret = Optional.empty();
		
		if(null != wbsElementName){
			ret= Optional.ofNullable(Converter.covertToWbsElementDTO(repository.findByWbsElementName(wbsElementName)));
		}
		return ret;
		
	}
	
	public List<WbsElementDTO> findByProjectWbsShortId(String wbsShortId) {
		List<WbsElementDTO> ret = new ArrayList<WbsElementDTO>();
		if(null != wbsShortId){
			ret= Converter.covertToWbsElementDTOList(repository.findByProjectWbsShortId(wbsShortId));
		}		
		return ret;
	}
	
	public List<WbsElementDTO> findByProjectId(Integer projectId) {
		List<WbsElementDTO> ret = new ArrayList<WbsElementDTO>();
		if(null != projectId){
			ret= Converter.covertToWbsElementDTOList(repository.findByProjectId(projectId));
		}		
		return ret;
	}
	

	public Optional<WbsElementDTO> findById(int id) {
		Optional<WbsElementDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToWbsElementDTO(repository.findById(id).get()));
		}		
		return ret;
	}
	
	public Optional<WbsElementDTO> add(WbsElementDTO wbsElementDTO) {
		Optional<WbsElementDTO> retwbsElementDTO= Optional.empty();
		if(wbsElementDTO.getId() == null || wbsElementDTO.getId() ==0){
			System.out.println("Before Insert :: " + wbsElementDTO.toString());
			retwbsElementDTO= Optional.ofNullable(Converter.covertToWbsElementDTO(repository.findByWbsElementName(wbsElementDTO.getWbsElementName())));
			System.out.println("Value Received from DB" + retwbsElementDTO.toString());
			if( (retwbsElementDTO.get().getId() == null)){
				System.out.println("Inserting into DB" + retwbsElementDTO.toString());
				retwbsElementDTO = Optional.ofNullable(Converter.covertToWbsElementDTO(repository.save(Converter.covertToWbsElement(wbsElementDTO))));
			}
			else{
				System.out.println("Value exists into DB" + wbsElementDTO.toString());
			}
		}
		else{
			retwbsElementDTO =  Optional.ofNullable(Converter.covertToWbsElementDTO(repository.save(Converter.covertToWbsElement(wbsElementDTO))));
		}
		
		return retwbsElementDTO;
	}
	

	
	public Optional<WbsElementDTO> update(WbsElementDTO wbsElementDTO) {
		Optional<WbsElementDTO> retProject= Optional.empty();
		retProject = Optional.ofNullable(Converter.covertToWbsElementDTO(repository.save(Converter.covertToWbsElement(wbsElementDTO))));
		return retProject;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
