package com.ibm.rest.webservices.restfulwebservices.ratechart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class RateChartDaoService {
	

	@Autowired
	private RateChartRepository repository;
	
	public List<RateChartDTO> findAll() {
		List<RateChartDTO> rateChartDTOList;
		rateChartDTOList = Converter.covertToRateChartDTOList(repository.findAll());
		return rateChartDTOList;		
		
	}
	
	public List<RateChartDTO> findByYear(int year) {
		List<RateChartDTO> ret = new ArrayList<RateChartDTO>();
		if(year > 0 ){
			ret= Converter.covertToRateChartDTOList(repository.findByYear(year));
		}		
		return ret;
	}
	
	public List<RateChartDTO> findByRateCode(String rateCode) {
		List<RateChartDTO> ret = new ArrayList<RateChartDTO>();
		if(null != rateCode ){
			ret= Converter.covertToRateChartDTOList(repository.findByRatecode(rateCode));
		}		
		return ret;
	}
	
	public List<RateChartDTO> findByYearAndRateCode(int year, String rateCode) {
		List<RateChartDTO> ret = new ArrayList<RateChartDTO>();
		if(year >0 && null != rateCode ){
			ret= Converter.covertToRateChartDTOList(repository.findByYearAndRatecode(year,rateCode));
		}		
		return ret;
	}
	
	
	public Optional<RateChartDTO> findById(int id) {
		Optional<RateChartDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToRateChartDTO(repository.findById(id).get()));
		}		
		return ret;
	}

	
	public Optional<RateChartDTO> save(RateChartDTO rateChartDTO) {
		Optional<RateChartDTO> ret= Optional.empty();
		ret = Optional.ofNullable(Converter.covertToRateChartDTO(repository.save(Converter.covertToRateChart(rateChartDTO))));
		return ret;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
