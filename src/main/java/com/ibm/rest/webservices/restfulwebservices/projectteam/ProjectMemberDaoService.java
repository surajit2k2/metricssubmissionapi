package com.ibm.rest.webservices.restfulwebservices.projectteam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class ProjectMemberDaoService {
	

	@Autowired
	private ProjectMemberRepository repository;
	
	public List<ProjectMemberDTO> findAll() {
		List<ProjectMemberDTO> projectMemberDTOList;
		projectMemberDTOList = Converter.covertToProjectMemberDTOList(repository.findAll());
		return projectMemberDTOList;		
	}
	
	public List<ProjectMemberDTO> findByWeekNumberAndProjectProjectCode(Integer weekNumber,String projectCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(weekNumber > 0 && null != projectCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByWeekNumberAndProjectProjectCode(weekNumber,projectCode));
		}
		return ret;
	}
	
	public List<ProjectMemberDTO> findByInvoiceCycleMonthAndProjectProjectCode(String invoiceMonth,String projectCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(null != invoiceMonth && null != projectCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByInvoiceCycleMonthAndProjectProjectCode(invoiceMonth,projectCode));
		}
		return ret;
	}
	
	public List<ProjectMemberDTO> findByWeekNumberAndResourceEmployeeCode(Integer weekNumber,String employeeCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(weekNumber > 0 && null != employeeCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByWeekNumberAndResourceEmployeeCode(weekNumber,employeeCode));
		}
		return ret;
	}
	
	public List<ProjectMemberDTO> findByInvoiceCycleMonthAndResourceEmployeeCode(String invoiceMonth,String employeeCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(null != invoiceMonth  && null != employeeCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByInvoiceCycleMonthAndResourceEmployeeCode(invoiceMonth,employeeCode));
		}
		return ret;
	}
	
	public List<ProjectMemberDTO> findByWeekNumberAndProjectProjectCodeAndResourceEmployeeCode(Integer weekNumber,String projectCode,String employeeCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(weekNumber > 0 && null!=projectCode  && null != employeeCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByWeekNumberAndProjectProjectCodeAndResourceEmployeeCode(weekNumber, projectCode, employeeCode));
		}
		return ret;
	}
	
	public List<ProjectMemberDTO> findByInvoiceCycleMonthAndProjectProjectCodeAndResourceEmployeeCode(String invoiceMonth,String projectCode,String employeeCode) {
		List<ProjectMemberDTO> ret = new ArrayList<ProjectMemberDTO>();
		if(null!= invoiceMonth && null!=projectCode  && null != employeeCode){
			ret= Converter.covertToProjectMemberDTOList(repository.findByInvoiceCycleMonthAndProjectProjectCodeAndResourceEmployeeCode(invoiceMonth,projectCode,employeeCode));
		}
		return ret;
	}

	public Optional<ProjectMemberDTO> findById(int id) {
		Optional<ProjectMemberDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToProjectMemberDTO(repository.findById(id).get()));
		}		
		return ret;
	}

	public Optional<ProjectMemberDTO> add(ProjectMemberDTO projectMemberDTO) {
		Optional<ProjectMemberDTO> retProjectMember= Optional.empty();
		
		retProjectMember = Optional.ofNullable(Converter.covertToProjectMemberDTO(repository.save(Converter.covertToProjectMember(projectMemberDTO))));
		return retProjectMember;
	}
	
	public Optional<ProjectMemberDTO> update(ProjectMemberDTO projectMemberDTO) {
		Optional<ProjectMemberDTO> retProjectMember= Optional.empty();
		retProjectMember = Optional.ofNullable(Converter.covertToProjectMemberDTO(repository.save(Converter.covertToProjectMember(projectMemberDTO))));
		return retProjectMember;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
