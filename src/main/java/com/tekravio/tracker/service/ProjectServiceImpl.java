package com.tekravio.tracker.service;
import java.util.ArrayList;
import com.tekravio.tracker.dto.ProjectHealthDTO;
import com.tekravio.tracker.model.Sprint;
import com.tekravio.tracker.model.Task;
import com.tekravio.tracker.model.TaskStatus;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekravio.tracker.dto.ProjectRequestDTO;
import com.tekravio.tracker.dto.ProjectResponseDTO;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import com.tekravio.tracker.model.Client;
import com.tekravio.tracker.model.Project;
import com.tekravio.tracker.model.ProjectStatus;
import com.tekravio.tracker.repository.ClientRepository;
import com.tekravio.tracker.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
     
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
		Client client = clientRepository.findById(dto.getClientId())
	            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

	    Project project = new Project();

	    project.setName(dto.getName());
	    project.setDescription(dto.getDescription());

	    project.setStatus(ProjectStatus.valueOf(dto.getStatus()));

	    project.setStartDate(dto.getStartDate());
	    project.setEndDate(dto.getEndDate());

	    project.setClient(client);

	    Project savedProject = projectRepository.save(project);

	    ProjectResponseDTO response = new ProjectResponseDTO();

	    response.setId(savedProject.getId());
	    response.setName(savedProject.getName());
	    response.setDescription(savedProject.getDescription());

	    response.setStatus(savedProject.getStatus().name());

	    response.setStartDate(savedProject.getStartDate());
	    response.setEndDate(savedProject.getEndDate());

	    response.setClientId(client.getId());
	    response.setClientName(client.getName());

	    return response;
	}

	@Override
	public List<ProjectResponseDTO> getAllProjects() {
		List<Project> projects = projectRepository.findAll();

	    List<ProjectResponseDTO> responseList = new ArrayList<>();

	    for (Project project : projects) {

	        ProjectResponseDTO dto = new ProjectResponseDTO();

	        dto.setId(project.getId());
	        dto.setName(project.getName());
	        dto.setDescription(project.getDescription());

	        dto.setStatus(project.getStatus().name());

	        dto.setStartDate(project.getStartDate());
	        dto.setEndDate(project.getEndDate());

	        dto.setClientId(project.getClient().getId());
	        dto.setClientName(project.getClient().getName());

	        responseList.add(dto);
	    }

	    return responseList;
	}

	@Override
	public ProjectResponseDTO getProjectById(Long id) {
		Project project = projectRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    ProjectResponseDTO dto = new ProjectResponseDTO();

	    dto.setId(project.getId());
	    dto.setName(project.getName());
	    dto.setDescription(project.getDescription());

	    dto.setStatus(project.getStatus().name());

	    dto.setStartDate(project.getStartDate());
	    dto.setEndDate(project.getEndDate());

	    dto.setClientId(project.getClient().getId());
	    dto.setClientName(project.getClient().getName());

	    return dto;
	
	}

	@Override
	public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO dto) {
		Project project = projectRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    Client client = clientRepository.findById(dto.getClientId())
	            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

	    project.setName(dto.getName());
	    project.setDescription(dto.getDescription());

	    project.setStatus(ProjectStatus.valueOf(dto.getStatus()));

	    project.setStartDate(dto.getStartDate());
	    project.setEndDate(dto.getEndDate());

	    project.setClient(client);

	    Project updatedProject = projectRepository.save(project);

	    ProjectResponseDTO response = new ProjectResponseDTO();

	    response.setId(updatedProject.getId());
	    response.setName(updatedProject.getName());
	    response.setDescription(updatedProject.getDescription());

	    response.setStatus(updatedProject.getStatus().name());

	    response.setStartDate(updatedProject.getStartDate());
	    response.setEndDate(updatedProject.getEndDate());

	    response.setClientId(client.getId());
	    response.setClientName(client.getName());

	    return response;
	}

	@Override
	public void deleteProject(Long id) {
		Project project = projectRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    projectRepository.delete(project);
		
	}
	
	@Override
	public ProjectHealthDTO getProjectHealth(Long projectId) {

	    Project project = projectRepository.findById(projectId)
	            .orElseThrow(() ->
	            new ResourceNotFoundException(
	            "Project not found"));

	    ProjectHealthDTO dto =
	            new ProjectHealthDTO();

	    dto.setProjectId(project.getId());
	    dto.setProjectName(project.getName());

	    int totalTasks = 0;
	    int completedTasks = 0;
	    int overdueTasks = 0;

	    for(Sprint sprint : project.getSprints()) {

	        for(Task task : sprint.getTasks()) {

	            totalTasks++;

	            if(task.getStatus() ==
	                    TaskStatus.DONE) {

	                completedTasks++;
	            }
	        }
	    }

	    double completionRate = 0;

	    if(totalTasks > 0) {

	        completionRate =
	                (completedTasks * 100.0)
	                / totalTasks;
	    }

	    int healthScore =
	            (int) completionRate
	            - (overdueTasks * 10);

	    if(healthScore < 0) {
	        healthScore = 0;
	    }

	    if(healthScore > 100) {
	        healthScore = 100;
	    }

	    String status;

	    if(healthScore >= 80) {
	        status = "GOOD";
	    }
	    else if(healthScore >= 50) {
	        status = "AVERAGE";
	    }
	    else {
	        status = "POOR";
	    }

	    dto.setCompletionRate(
	            completionRate);

	    dto.setOverdueTasks(
	            overdueTasks);

	    dto.setHealthScore(
	            healthScore);

	    dto.setStatus(
	            status);

	    return dto;
	}

}
