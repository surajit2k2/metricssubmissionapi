package com.ibm.rest.webservices.restfulwebservices.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class ContractDaoService {
	

	@Autowired
	private ContractRepository repository;
	
	public List<ContractDTO> findAll() {
		
		List<ContractDTO> contractDTOList;
		contractDTOList = Converter.covertToContractDTOList(repository.findAll());
		return contractDTOList;
		
	}
	
	public Optional<ContractDTO> findContractByCode(String contractCode) {
		
		Optional<ContractDTO> ret = Optional.empty();
		if(null != contractCode){
			ret= Optional.ofNullable(Converter.covertToContractDTO(repository.findByContractCode(contractCode)));
		}
		return ret;
	}
	
	public List<ContractDTO> findContractBySubGroupId(Integer subGroupId) {
		List<ContractDTO> ret = new ArrayList<ContractDTO>() ;
		if(subGroupId > 0){
			ret= Converter.covertToContractDTOList(repository.findBySubGroupId(subGroupId));
		}
		return ret;
	}
	
	public List<ContractDTO> findContractBySubGroupName(String subGroupName) {
		List<ContractDTO> ret = new ArrayList<ContractDTO>() ;
		if(subGroupName != null){
			ret= Converter.covertToContractDTOList(repository.findBySubGroupSubGroupName(subGroupName));
		}
		return ret;
	}
	
	public List<ContractDTO> findContractByRegionId(Integer regionId) {
		List<ContractDTO> ret = new ArrayList<ContractDTO>() ;
		if(regionId > 0){
			ret= Converter.covertToContractDTOList(repository.findBySubGroupRegionId(regionId));
		}
		return ret;
	}
	public List<ContractDTO> findContractByRegionName(String regionName) {
		List<ContractDTO> ret = new ArrayList<ContractDTO>() ;
		if(regionName != null){
			ret= Converter.covertToContractDTOList(repository.findBySubGroupRegionRegionName(regionName));
		}
		return ret;
	}
	
	public Optional<ContractDTO> findById(int id) {
		Optional<ContractDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToContractDTO(repository.findById(id).get()));
		}		
		return ret;
	}

	public Optional<ContractDTO> add(ContractDTO contractDTO) {
		Optional<ContractDTO> retContractDTO= Optional.empty();
		if(contractDTO.getId() == null || contractDTO.getId() ==0){
			System.out.println("Before Insert :: " + contractDTO.toString());
			retContractDTO= Optional.ofNullable(Converter.covertToContractDTO(repository.findByContractCode(contractDTO.getContractCode())));
			System.out.println("Value Received from DB" + retContractDTO.toString());
			if( (retContractDTO.get().getId() == null)){
				System.out.println("Inserting into DB" + retContractDTO.toString());
				retContractDTO = Optional.ofNullable(Converter.covertToContractDTO(repository.save(Converter.covertToContract(contractDTO))));
			}
			else{
				System.out.println("Value exists into DB" + contractDTO.toString());
			}
		}
		else{
			retContractDTO =  Optional.ofNullable(Converter.covertToContractDTO(repository.save(Converter.covertToContract(contractDTO))));
		}
		
		return retContractDTO;
	}
	
	public Optional<ContractDTO> update(ContractDTO contractDTO) {
		Optional<ContractDTO> retSubGroup= Optional.empty();
		retSubGroup = Optional.ofNullable(Converter.covertToContractDTO(repository.save(Converter.covertToContract(contractDTO))));
		return retSubGroup;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
