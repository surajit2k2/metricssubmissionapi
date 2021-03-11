package com.ibm.rest.webservices.restfulwebservices.invoicecycle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceCycleRepository extends JpaRepository<InvoiceCycle, Integer>{
	List<InvoiceCycle> findByYear(Integer year);
	List<InvoiceCycle> findByMonth(String month);
	List<InvoiceCycle> findByYearAndMonth(int year, String month);
}
