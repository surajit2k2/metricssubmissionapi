package com.ibm.rest.webservices.restfulwebservices.region;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class RegionDaoService {
	

	@Autowired
	private RegionRepository repository;
	
	public List<RegionDTO> findAll() {
		List<RegionDTO> regionDTOList ;
		regionDTOList = Converter.covertToRegionDTOList(repository.findAll());
		return regionDTOList;
	}


	
	public Optional<RegionDTO> findRegionByName(String regionName) {
		Optional<RegionDTO> ret = Optional.empty();
		if(null != regionName){
			ret= Optional.ofNullable(Converter.covertToRegionDTO(repository.findByRegionName(regionName)));
		}
		
		return ret;
	}
	public Optional<RegionDTO> findById(int id) {
		Optional<RegionDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToRegionDTO(repository.findById(id).get()));
		}		
		return ret;
	
	}

	public Optional<RegionDTO> save(RegionDTO regionDTO) {
		Optional<RegionDTO> retRegionDTO= Optional.empty();
		if(regionDTO.getId() == 0){
			retRegionDTO = Optional.ofNullable(Converter.covertToRegionDTO(repository.save(Converter.covertToRegion(regionDTO))));
			
		}
		else{
			retRegionDTO = Optional.ofNullable(Converter.covertToRegionDTO(repository.save(Converter.covertToRegion(regionDTO))));
		}		
		return retRegionDTO;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	

	
	

}
