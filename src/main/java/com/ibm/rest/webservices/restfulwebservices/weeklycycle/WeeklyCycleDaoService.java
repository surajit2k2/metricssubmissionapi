package com.ibm.rest.webservices.restfulwebservices.weeklycycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class WeeklyCycleDaoService {

	@Autowired
	private WeeklyCycleRepository repository;

	public List<WeeklyCycleDTO> findAll() {
		List<WeeklyCycleDTO> weeklyCycleDTOList;
		weeklyCycleDTOList = Converter.covertToWeeklyCycleDTOList(repository.findAll());
		return weeklyCycleDTOList;

	}

	public List<WeeklyCycleDTO> findByYear(int year) {
		List<WeeklyCycleDTO> ret = new ArrayList<WeeklyCycleDTO>();
		if (year > 0) {
			ret = Converter.covertToWeeklyCycleDTOList(repository.findByInvoiceCycleYear(year));
		}
		return ret;
	}

	public List<WeeklyCycleDTO> findByYearAndMonth(int year, String month) {
		List<WeeklyCycleDTO> ret = new ArrayList<WeeklyCycleDTO>();
		if (year > 0) {
			ret = Converter.covertToWeeklyCycleDTOList(repository.findByInvoiceCycleYearAndInvoiceCycleMonth(year, month));
		}
		return ret;
	}

	public List<WeeklyCycleDTO> findByMonth(String month) {
		List<WeeklyCycleDTO> ret = new ArrayList<WeeklyCycleDTO>();
		if (month != null) {
			ret = Converter.covertToWeeklyCycleDTOList(repository.findByInvoiceCycleMonth(month));
		}
		return ret;
	}
	
	public List<WeeklyCycleDTO> findByInvoiceCycleId(Integer invoiceCycleId) {
		List<WeeklyCycleDTO> ret = new ArrayList<WeeklyCycleDTO>();
		if (invoiceCycleId > 0) {
			ret = Converter.covertToWeeklyCycleDTOList(repository.findByInvoiceCycleId(invoiceCycleId));
		}
		return ret;
	}

	public Optional<WeeklyCycleDTO> findById(int id) {
		Optional<WeeklyCycleDTO> ret = Optional.empty();
		if (id > 0) {
			ret = Optional.ofNullable(Converter.covertToWeeklyCycleDTO(repository.findById(id).get()));
		}
		return ret;
	}

	public Optional<WeeklyCycleDTO> findByWeekEnding(String weekEnding) {
		Optional<WeeklyCycleDTO> ret = Optional.empty();
		if (weekEnding != null) {
			ret = Optional.ofNullable(Converter.covertToWeeklyCycleDTO(repository.findByWeekEnding(weekEnding)));
		}
		return ret;
	}
	
	public Optional<WeeklyCycleDTO> save(WeeklyCycleDTO weeklyCycleDTO) {
		Optional<WeeklyCycleDTO> ret = Optional.empty();
		ret = Optional.ofNullable(
				Converter.covertToWeeklyCycleDTO(repository.save(Converter.covertToWeeklyCycle(weeklyCycleDTO))));
		return ret;

	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
