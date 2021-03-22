package com.ibm.rest.webservices.restfulwebservices.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{
	Contract findByContractCode(String contractCode);
	List<Contract> findBySubGroupId(Integer id);
	List<Contract> findBySubGroupSubGroupName(String subGroupName);
	
	List<Contract> findBySubGroupRegionId(Integer id);
	List<Contract> findBySubGroupRegionRegionName(String regionName);
	
}
