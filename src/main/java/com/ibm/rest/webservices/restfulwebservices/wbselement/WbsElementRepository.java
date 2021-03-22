package com.ibm.rest.webservices.restfulwebservices.wbselement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WbsElementRepository extends JpaRepository<WbsElement, Integer>{
	WbsElement findByWbsElementName(String wbsElementName);
	List<WbsElement> findByProjectId(Integer projectId);
	List<WbsElement> findByProjectWbsShortId(String wbsShortId);

}
