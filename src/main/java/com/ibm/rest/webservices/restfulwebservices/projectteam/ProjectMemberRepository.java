package com.ibm.rest.webservices.restfulwebservices.projectteam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer>{
	List<ProjectMember> findByWeekNumberAndProjectWbsShortId(Integer weekNumber,String wbsShortId);
	List<ProjectMember> findByInvoiceCycleMonthAndProjectWbsShortId(String invoiceMonth,String wbsShortId);
	List<ProjectMember> findByWeekNumberAndResourceEmployeeCode(Integer weekNumber,String employeeCode);
	List<ProjectMember> findByInvoiceCycleMonthAndResourceEmployeeCode(String invoiceMonth,String employeeCode);
	List<ProjectMember> findByWeekNumberAndProjectWbsShortIdAndResourceEmployeeCode(Integer weekNumber,String wbsShortId,String employeeCode);
	List<ProjectMember> findByInvoiceCycleMonthAndProjectWbsShortIdAndResourceEmployeeCode(String invoiceMonth,String wbsShortId,String employeeCode);
	
	
}
