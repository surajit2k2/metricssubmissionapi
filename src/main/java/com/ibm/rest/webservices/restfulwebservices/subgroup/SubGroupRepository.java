package com.ibm.rest.webservices.restfulwebservices.subgroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGroupRepository extends JpaRepository<SubGroup, Integer>{
	SubGroup findBySubGroupName(String subGroupName);
	List<SubGroup> findByRegionId(Integer id);
	
}
