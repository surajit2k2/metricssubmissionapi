package com.ibm.rest.webservices.restfulwebservices.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer>{
	List<Resource> findByEmployeeName(String employeeName);
	Resource findByEmployeeCode(String employeeCode);
	List<Resource> findByEmployeeBand(String employeeBand);
	List<Resource> findByWorkingPlace(String workingPlace);
	
}
