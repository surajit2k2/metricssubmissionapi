package com.ibm.rest.webservices.restfulwebservices.helper;

import java.util.ArrayList;
import java.util.List;

import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycle;
import com.ibm.rest.webservices.restfulwebservices.invoicecycle.InvoiceCycleDTO;
import com.ibm.rest.webservices.restfulwebservices.project.Project;
import com.ibm.rest.webservices.restfulwebservices.project.ProjectDTO;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMember;
import com.ibm.rest.webservices.restfulwebservices.projectteam.ProjectMemberDTO;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChart;
import com.ibm.rest.webservices.restfulwebservices.ratechart.RateChartDTO;
import com.ibm.rest.webservices.restfulwebservices.region.Region;
import com.ibm.rest.webservices.restfulwebservices.region.RegionDTO;
import com.ibm.rest.webservices.restfulwebservices.resource.Resource;
import com.ibm.rest.webservices.restfulwebservices.resource.ResourceDTO;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroup;
import com.ibm.rest.webservices.restfulwebservices.subgroup.SubGroupDTO;
import com.ibm.rest.webservices.restfulwebservices.weeklycycle.WeeklyCycle;
import com.ibm.rest.webservices.restfulwebservices.weeklycycle.WeeklyCycleDTO;

public class Converter {
	
	public static List<RegionDTO> covertToRegionDTOList(List<Region> regionList) {
		List<RegionDTO> regionDTOList = new ArrayList<RegionDTO>();
		
		for (Region region : regionList){
			RegionDTO regionDTO = covertToRegionDTO(region);
			regionDTOList.add(regionDTO);
		}
		return regionDTOList;
	}
	
	public static RegionDTO covertToRegionDTO(Region region) {
		    RegionDTO regionDTO = new RegionDTO();
		    if(region != null){
		   		regionDTO.setId(region.getId());
				regionDTO.setRegionName(region.getRegionName());
		    }
		    return regionDTO;
	}
	
	public static Region covertToRegion(RegionDTO regionDTO) {
	    Region region = new Region();
	    if(regionDTO != null){
	   		region.setId(regionDTO.getId());
			region.setRegionName(regionDTO.getRegionName());
	    }
	    return region;
	}
	
	public static List<SubGroupDTO> covertToSubGroupDTOList(List<SubGroup> subGroupList) {
		List<SubGroupDTO> subGroupDTOList = new ArrayList<SubGroupDTO>();
		for (SubGroup subGroup : subGroupList){
			SubGroupDTO subGroupDTO = covertToSubGroupDTO(subGroup);
		    subGroupDTOList.add(subGroupDTO);
		}
		return subGroupDTOList;
	}
	
	public static SubGroupDTO covertToSubGroupDTO(SubGroup subGroup) {
	    SubGroupDTO subGroupDTO = new SubGroupDTO();
	    if(subGroup != null){
		    subGroupDTO.setId(subGroup.getId());
		    subGroupDTO.setSubGroupName(subGroup.getSubGroupName());
		    subGroupDTO.setRegion(covertToRegionDTO(subGroup.getRegion()));
	    }
	    return subGroupDTO;
	}
	
	public static SubGroup covertToSubGroup(SubGroupDTO subGroupDTO) {
		SubGroup subGroup = new SubGroup();
		if(subGroupDTO != null){
			subGroup.setId(subGroupDTO.getId());
			subGroup.setSubGroupName(subGroupDTO.getSubGroupName());
			subGroup.setRegion(covertToRegion(subGroupDTO.getRegion()));
		}
	    return subGroup;
	}
	
	public static List<ProjectDTO> covertToProjectDTOList(List<Project> projectList) {
		List<ProjectDTO> subProjectDTOList = new ArrayList<ProjectDTO>();
		for (Project project : projectList){
			ProjectDTO projectDTO = covertToProjectDTO(project);
			subProjectDTOList.add(projectDTO);
		}
		return subProjectDTOList;
	}
	
	public static ProjectDTO covertToProjectDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		if(project != null){
			projectDTO.setId(project.getId());
			projectDTO.setDeliveryProjectManager(project.getDeliveryProjectManager());
			projectDTO.setProjectCode(project.getProjectCode());
			projectDTO.setProjectName(project.getProjectName());
			projectDTO.setProjectEndDate(project.getProjectEndDate());
			projectDTO.setProjectManager(project.getProjectManager());
			projectDTO.setProjectStartDate(project.getProjectStartDate());
			projectDTO.setProjectStaus(project.getProjectStaus());
			projectDTO.setSubGroup(covertToSubGroupDTO(project.getSubGroup()));
		}
	    return projectDTO;
	}
	
	public static Project covertToProject(ProjectDTO projectDTO) {
		Project project = new Project();
		if(projectDTO != null){
			project.setId(projectDTO.getId());
			project.setDeliveryProjectManager(projectDTO.getDeliveryProjectManager());
			project.setProjectCode(projectDTO.getProjectCode());
			project.setProjectName(projectDTO.getProjectName());
			project.setProjectEndDate(projectDTO.getProjectEndDate());
			project.setProjectManager(projectDTO.getProjectManager());
			project.setProjectStartDate(projectDTO.getProjectStartDate());
			project.setProjectStaus(projectDTO.getProjectStaus());
			project.setSubGroup(covertToSubGroup(projectDTO.getSubGroup()));
		}
	    return project;
	}
	
	public static List<ResourceDTO> covertToResourceDTOList(List<Resource> resourceList) {
		List<ResourceDTO> subresourceDTOList = new ArrayList<ResourceDTO>();
		for (Resource resource : resourceList){
			ResourceDTO resourceDTO = covertToResourceDTO(resource);
			subresourceDTOList.add(resourceDTO);
		}
		return subresourceDTOList;
	}
	
	public static ResourceDTO covertToResourceDTO(Resource resource) {
		ResourceDTO resourceDTO = new ResourceDTO();
		if(resource != null){
			resourceDTO.setId(resource.getId());
			resourceDTO.setEmployeeBand(resource.getEmployeeBand());
			resourceDTO.setEmployeeCode(resource.getEmployeeCode());
			resourceDTO.setEmployeeName(resource.getEmployeeName());
			resourceDTO.setWorkingPlace(resource.getWorkingPlace());
		
		}
	    return resourceDTO;
	}
	
	public static Resource covertToResource(ResourceDTO resourceDTO) {
		Resource resource = new Resource();
		if(resourceDTO != null){
			resource.setId(resourceDTO.getId());
			resource.setEmployeeBand(resourceDTO.getEmployeeBand());
			resource.setEmployeeCode(resourceDTO.getEmployeeCode());
			resource.setEmployeeName(resourceDTO.getEmployeeName());
			resource.setWorkingPlace(resourceDTO.getWorkingPlace());
		
		}
	    return resource;
	}
	
	public static List<RateChartDTO> covertToRateChartDTOList(List<RateChart> rateChartList) {
		List<RateChartDTO> rateChartDTOList = new ArrayList<RateChartDTO>();
		for (RateChart rateChart : rateChartList){
			RateChartDTO rateChartDTO = covertToRateChartDTO(rateChart);
			rateChartDTOList.add(rateChartDTO);
		}
		return rateChartDTOList;
	}
	
	public static RateChartDTO covertToRateChartDTO(RateChart rateChart) {
		RateChartDTO rateChartDTO = new RateChartDTO();
		if(rateChart != null){
			rateChartDTO.setId(rateChart.getId());
			rateChartDTO.setBillcode(rateChart.getBillcode());
			rateChartDTO.setBillrate(rateChart.getBillrate());
			rateChartDTO.setDesc(rateChart.getDesc());
			rateChartDTO.setInfo(rateChart.getInfo());
			rateChartDTO.setRatecode(rateChart.getRatecode());
			rateChartDTO.setYear(rateChart.getYear());
		}
	    return rateChartDTO;
	}
	
	public static RateChart covertToRateChart(RateChartDTO rateChartDTO) {
		RateChart rateChart = new RateChart();
		if(rateChartDTO != null){
			rateChart.setId(rateChartDTO.getId());
			rateChart.setBillcode(rateChartDTO.getBillcode());
			rateChart.setBillrate(rateChartDTO.getBillrate());
			rateChart.setDesc(rateChartDTO.getDesc());
			rateChart.setInfo(rateChartDTO.getInfo());
			rateChart.setRatecode(rateChartDTO.getRatecode());
			rateChart.setYear(rateChartDTO.getYear());
		}
	    return rateChart;
	}
	
	public static List<InvoiceCycleDTO> covertToInvoiceCycleDTOList(List<InvoiceCycle> invoiceCycleList) {
		List<InvoiceCycleDTO> invoiceCycleDTOList = new ArrayList<InvoiceCycleDTO>();
		for (InvoiceCycle invoiceCycle : invoiceCycleList){
			InvoiceCycleDTO invoiceCycleDTO = covertToInvoiceCycleDTO(invoiceCycle);
			invoiceCycleDTOList.add(invoiceCycleDTO);
		}
		return invoiceCycleDTOList;
	}
	
	public static InvoiceCycleDTO covertToInvoiceCycleDTO(InvoiceCycle invoiceCycle) {
		InvoiceCycleDTO invoiceCycleDTO = new InvoiceCycleDTO();
		if(invoiceCycle != null){
			invoiceCycleDTO.setId(invoiceCycle.getId());
			invoiceCycleDTO.setInvoiceEndDate(invoiceCycle.getInvoiceEndDate());
			invoiceCycleDTO.setInvoiceStartDate(invoiceCycle.getInvoiceStartDate());
			invoiceCycleDTO.setMonth(invoiceCycle.getMonth());
			invoiceCycleDTO.setNoOfWeekInCycle(invoiceCycle.getNoOfWeekInCycle());
			invoiceCycleDTO.setTimeSheetDueDate(invoiceCycle.getTimeSheetDueDate());
			invoiceCycleDTO.setWeekNumber(invoiceCycle.getWeekNumber());
			invoiceCycleDTO.setYear(invoiceCycle.getYear());
		}
	    return invoiceCycleDTO;
	}
	
	public static InvoiceCycle covertToInvoiceCycle(InvoiceCycleDTO invoiceCycleDTO) {
		InvoiceCycle invoiceCycle = new InvoiceCycle();
		if(invoiceCycleDTO != null){
			invoiceCycle.setId(invoiceCycleDTO.getId());
			invoiceCycle.setInvoiceEndDate(invoiceCycleDTO.getInvoiceEndDate());
			invoiceCycle.setInvoiceStartDate(invoiceCycleDTO.getInvoiceStartDate());
			invoiceCycle.setMonth(invoiceCycleDTO.getMonth());
			invoiceCycle.setNoOfWeekInCycle(invoiceCycleDTO.getNoOfWeekInCycle());
			invoiceCycle.setTimeSheetDueDate(invoiceCycleDTO.getTimeSheetDueDate());
			invoiceCycle.setWeekNumber(invoiceCycleDTO.getWeekNumber());
			invoiceCycle.setYear(invoiceCycleDTO.getYear());
		}
	    return invoiceCycle;
	}
	
	public static List<ProjectMemberDTO> covertToProjectMemberDTOList(List<ProjectMember> projectMemberList) {
		List<ProjectMemberDTO> projectMemberDTOList = new ArrayList<ProjectMemberDTO>();
		for (ProjectMember projectMember : projectMemberList){
			ProjectMemberDTO projectMemberDTO = covertToProjectMemberDTO(projectMember);
			projectMemberDTOList.add(projectMemberDTO);
		}
		return projectMemberDTOList;
	}
	
	public static ProjectMemberDTO covertToProjectMemberDTO(ProjectMember projectMember) {
		ProjectMemberDTO projectMemberDTO = new ProjectMemberDTO();
		if(projectMember != null){
			projectMemberDTO.setId(projectMember.getId());
			projectMemberDTO.setClaimHours(projectMember.getClaimHours());
			projectMemberDTO.setWeekNumber(projectMember.getWeekNumber());
			projectMemberDTO.setInvoiceCycle(covertToInvoiceCycleDTO(projectMember.getInvoiceCycle()));
			projectMemberDTO.setProject(covertToProjectDTO(projectMember.getProject()));
			projectMemberDTO.setRateChart(covertToRateChartDTO(projectMember.getRateChart()));
			projectMemberDTO.setResource(covertToResourceDTO(projectMember.getResource()));
		
		}
	    return projectMemberDTO;
	}
	
	public static ProjectMember covertToProjectMember(ProjectMemberDTO projectMemberDTO) {
		ProjectMember projectMember = new ProjectMember();
		if(projectMemberDTO != null){
			projectMember.setId(projectMemberDTO.getId());
			projectMember.setClaimHours(projectMemberDTO.getClaimHours());
			projectMember.setWeekNumber(projectMemberDTO.getWeekNumber());
			projectMember.setInvoiceCycle(covertToInvoiceCycle(projectMemberDTO.getInvoiceCycle()));
			projectMember.setProject(covertToProject(projectMemberDTO.getProject()));
			projectMember.setRateChart(covertToRateChart(projectMemberDTO.getRateChart()));
			projectMember.setResource(covertToResource(projectMemberDTO.getResource()));
		
		}
	    return projectMember;
	}
	
	public static List<WeeklyCycleDTO> covertToWeeklyCycleDTOList(List<WeeklyCycle> weeklyCycleList) {
		List<WeeklyCycleDTO> weeklyCycleDTOList = new ArrayList<WeeklyCycleDTO>();
		for (WeeklyCycle weeklyCycle : weeklyCycleList){
			WeeklyCycleDTO weeklyCycleDTO = covertToWeeklyCycleDTO(weeklyCycle);
			weeklyCycleDTOList.add(weeklyCycleDTO);
		}
		return weeklyCycleDTOList;
	}
	
	public static WeeklyCycleDTO covertToWeeklyCycleDTO(WeeklyCycle weeklyCycle) {
		WeeklyCycleDTO weeklyCycleDTO = new WeeklyCycleDTO();
		if(weeklyCycle != null){
			weeklyCycleDTO.setId(weeklyCycle.getId());
			weeklyCycleDTO.setWeekEnding(weeklyCycle.getWeekEnding());
			weeklyCycleDTO.setInvoiceCycle(covertToInvoiceCycleDTO(weeklyCycle.getInvoiceCycle()));
		}
	    return weeklyCycleDTO;
	}
	
	public static WeeklyCycle covertToWeeklyCycle(WeeklyCycleDTO weeklyCycleDTO) {
		WeeklyCycle weeklyCycle = new WeeklyCycle();
		if(weeklyCycleDTO != null){
			weeklyCycle.setId(weeklyCycleDTO.getId());
			weeklyCycle.setWeekEnding(weeklyCycleDTO.getWeekEnding());
			weeklyCycle.setInvoiceCycle(covertToInvoiceCycle(weeklyCycleDTO.getInvoiceCycle()));
		}
	    return weeklyCycle;
	}
}
