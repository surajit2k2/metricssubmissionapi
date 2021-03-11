package com.ibm.rest.webservices.restfulwebservices.ratechart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateChartRepository extends JpaRepository<RateChart, Integer>{
	List<RateChart> findByRatecode(String ratecode);
	List<RateChart> findByYearAndRatecode(int year, String ratecode);
	List<RateChart> findByYear(int year);

}
