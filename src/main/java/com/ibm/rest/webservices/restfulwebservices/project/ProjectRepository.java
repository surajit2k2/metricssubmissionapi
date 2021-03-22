package com.ibm.rest.webservices.restfulwebservices.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	List<Project> findByProjectName(String projectName);
	List<Project> findByWbsShortId(String wbsShortId);
	List<Project> findByContractId(Integer ContractId);
	List<Project> findByContractContractCode(String contractCode);
}
