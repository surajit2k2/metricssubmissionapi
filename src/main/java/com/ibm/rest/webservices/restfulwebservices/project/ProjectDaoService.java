package com.ibm.rest.webservices.restfulwebservices.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.rest.webservices.restfulwebservices.helper.Converter;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;

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
	
	public List<ProjectDTO> findByProjectCode(String projectCode) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(null != projectCode){
			ret= Converter.covertToProjectDTOList(repository.findByProjectCode(projectCode));
		}		
		return ret;
	}
	
	public List<ProjectDTO> findBySubGroupId(Integer subGroupId) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(subGroupId > 0){
			ret= Converter.covertToProjectDTOList(repository.findBySubGroupId(subGroupId));
		}		
		return ret;
	}
	
	public List<ProjectDTO> findBySubGroupName(String subGroupName) {
		List<ProjectDTO> ret = new ArrayList<ProjectDTO>();
		if(null != subGroupName){
			ret= Converter.covertToProjectDTOList(repository.findBySubGroupSubGroupName(subGroupName));
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
