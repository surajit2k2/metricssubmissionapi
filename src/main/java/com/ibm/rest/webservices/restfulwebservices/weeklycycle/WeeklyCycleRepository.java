package com.ibm.rest.webservices.restfulwebservices.weeklycycle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyCycleRepository extends JpaRepository<WeeklyCycle, Integer>{
	List<WeeklyCycle> findByInvoiceCycleId(Integer InvoiceCycleId);
	List<WeeklyCycle> findByInvoiceCycleMonth(String invoiceCycleMonth);
	List<WeeklyCycle> findByInvoiceCycleYearAndInvoiceCycleMonth(Integer year, String invoiceCycleMonth);
	List<WeeklyCycle> findByInvoiceCycleYear(Integer year);
	WeeklyCycle findByWeekEnding(String weekEnding);
	
}
