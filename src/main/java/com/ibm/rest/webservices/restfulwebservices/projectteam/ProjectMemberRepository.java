package com.ibm.rest.webservices.restfulwebservices.projectteam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer>{
	List<ProjectMember> findByWeekNumberAndProjectProjectCode(Integer weekNumber,String projectCode);
	List<ProjectMember> findByInvoiceCycleMonthAndProjectProjectCode(String invoiceMonth,String projectCode);
	List<ProjectMember> findByWeekNumberAndResourceEmployeeCode(Integer weekNumber,String employeeCode);
	List<ProjectMember> findByInvoiceCycleMonthAndResourceEmployeeCode(String invoiceMonth,String employeeCode);
	List<ProjectMember> findByWeekNumberAndProjectProjectCodeAndResourceEmployeeCode(Integer weekNumber,String projectCode,String employeeCode);
	List<ProjectMember> findByInvoiceCycleMonthAndProjectProjectCodeAndResourceEmployeeCode(String invoiceMonth,String projectCode,String employeeCode);
	
	
}
