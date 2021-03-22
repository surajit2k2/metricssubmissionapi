package com.ibm.rest.webservices.restfulwebservices.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;

@Service
public class ProjectDaoService {
	

	@Autowired
	private ProjectRepository repository;
	
	public List<ProjectDTO> findAll() {
		List<ProjectDTO> projectDTOList;
		projectDTOList = Converter.covertToProjectDTOList(repository.findAll());
		return projectDTOList;		
	}
	
	public List<ProjectDTO> findByProjectName(String projectName) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		
		if(null != projectName){
			ret= Converter.covertToProjectDTOList(repository.findByProjectName(projectName));
		}
		return ret;
		
	}
	
	public List<ProjectDTO> findByProjectCode(String wbsShortId) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(null != wbsShortId){
			ret= Converter.covertToProjectDTOList(repository.findByWbsShortId(wbsShortId));
		}		
		return ret;
	}
	
	public List<ProjectDTO> findByContractId(Integer contractId) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(contractId > 0){
			ret= Converter.covertToProjectDTOList(repository.findByContractId(contractId));
		}		
		return ret;
	}
	
	public List<ProjectDTO> findByContractCode(String contractCode) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(null != contractCode){
			ret= Converter.covertToProjectDTOList(repository.findByContractContractCode(contractCode));
		}		
		return ret;
	}
	

	public Optional<ProjectDTO> findById(int id) {
		Optional<ProjectDTO> ret = Optional.empty();
		if(id > 0){
			ret= Optional.ofNullable(Converter.covertToProjectDTO(repository.findById(id).get()));
		}		
		return ret;
	}

	public Optional<ProjectDTO> add(ProjectDTO projectDTO) {
		Optional<ProjectDTO> retProject= Optional.empty();
		
		retProject = Optional.ofNullable(Converter.covertToProjectDTO(repository.save(Converter.covertToProject(projectDTO))));
		return retProject;
	}
	
	public Optional<ProjectDTO> update(ProjectDTO projectDTO) {
		Optional<ProjectDTO> retProject= Optional.empty();
		retProject = Optional.ofNullable(Converter.covertToProjectDTO(repository.save(Converter.covertToProject(projectDTO))));
		return retProject;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	

}
