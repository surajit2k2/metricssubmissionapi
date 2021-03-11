package com.ibm.rest.webservices.restfulwebservices.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	List<Project> findByProjectName(String projectName);
	List<Project> findByProjectCode(String projectCode);
	List<Project> findBySubGroupId(Integer subGroupId);
	List<Project> findBySubGroupSubGroupName(String subGroupName);
}
