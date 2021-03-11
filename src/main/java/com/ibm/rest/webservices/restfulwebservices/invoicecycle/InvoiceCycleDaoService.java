package com.ibm.rest.webservices.restfulwebservices.invoicecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class InvoiceCycleDaoService {
	

	@Autowired
	private InvoiceCycleRepository repository;
	
	public List<InvoiceCycleDTO> findAll() {
		List<InvoiceCycleDTO> invoiceCycleDTOList;
		invoiceCycleDTOList = Converter.covertToInvoiceCycleDTOList(repository.findAll());
		return invoiceCycleDTOList;	
		
	}
	
	public List<InvoiceCycleDTO> findByYear(int year) {
		List<InvoiceCycleDTO> ret = new ArrayList<InvoiceCycleDTO>();
		if(year > 0 ){
			ret= Converter.covertToInvoiceCycleDTOList(repository.findByYear(year));
		}		
		return ret;
	}
	
	public List<InvoiceCycleDTO> findByMonth(String month) {
		List<InvoiceCycleDTO> ret = new ArrayList<InvoiceCycleDTO>();
		if(null != month ){
			ret= Converter.covertToInvoiceCycleDTOList(repository.findByMonth(month));
		}		
		return ret;
	}
	
	public List<InvoiceCycleDTO> findByYearAndMonth(int year,  String month) {
		List<InvoiceCycleDTO> ret = new ArrayList<InvoiceCycleDTO>();
		if(year >0 && null != month ){
			ret= Converter.covertToInvoiceCycleDTOList(repository.findByYearAndMonth(year,month));
		}		
		return ret;
	}
	
	
	public Optional<InvoiceCycleDTO> findById(int id) {
		Optional<InvoiceCycleDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToInvoiceCycleDTO(repository.findById(id).get()));
		}		
		return ret;
	
	}

	public Optional<InvoiceCycleDTO> save(InvoiceCycleDTO invoiceCycleDTO) {
		Optional<InvoiceCycleDTO> ret= Optional.empty();
		ret = Optional.ofNullable(Converter.covertToInvoiceCycleDTO(repository.save(Converter.covertToInvoiceCycle(invoiceCycleDTO))));
		return ret;
	
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
