package com.tekravio.tracker.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekravio.tracker.dto.SprintRequestDTO;
import com.tekravio.tracker.dto.SprintResponseDTO;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import com.tekravio.tracker.model.Project;
import com.tekravio.tracker.model.Sprint;
import com.tekravio.tracker.model.SprintStatus;
import com.tekravio.tracker.repository.ProjectRepository;
import com.tekravio.tracker.repository.SprintRepository;
import java.util.HashMap;
import java.util.Map;

import com.tekravio.tracker.dto.SprintSummaryDTO;
import com.tekravio.tracker.model.Task;
import com.tekravio.tracker.model.TaskPriority;
import com.tekravio.tracker.model.TaskStatus;

@Service
public class SprintServiceImpl implements SprintService {
	
    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
	@Override
	public SprintResponseDTO createSprint(SprintRequestDTO dto) {
		Project project = projectRepository.findById(dto.getProjectId())
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    Sprint sprint = new Sprint();

	    sprint.setSprintNumber(dto.getSprintNumber());
	    sprint.setGoal(dto.getGoal());

	    sprint.setStatus(SprintStatus.valueOf(dto.getStatus()));

	    sprint.setStartDate(dto.getStartDate());
	    sprint.setEndDate(dto.getEndDate());

	    sprint.setProject(project);

	    Sprint savedSprint = sprintRepository.save(sprint);

	    SprintResponseDTO response = new SprintResponseDTO();

	    response.setId(savedSprint.getId());
	    response.setSprintNumber(savedSprint.getSprintNumber());
	    response.setGoal(savedSprint.getGoal());

	    response.setStatus(savedSprint.getStatus().name());

	    response.setStartDate(savedSprint.getStartDate());
	    response.setEndDate(savedSprint.getEndDate());

	    response.setProjectId(project.getId());
	    response.setProjectName(project.getName());

	    return response;
	}

	@Override
	public List<SprintResponseDTO> getAllSprints() {
		List<Sprint> sprints = sprintRepository.findAll();

	    List<SprintResponseDTO> responseList = new ArrayList<>();

	    for (Sprint sprint : sprints) {

	        SprintResponseDTO dto = new SprintResponseDTO();

	        dto.setId(sprint.getId());
	        dto.setSprintNumber(sprint.getSprintNumber());
	        dto.setGoal(sprint.getGoal());

	        dto.setStatus(sprint.getStatus().name());

	        dto.setStartDate(sprint.getStartDate());
	        dto.setEndDate(sprint.getEndDate());

	        dto.setProjectId(sprint.getProject().getId());
	        dto.setProjectName(sprint.getProject().getName());

	        responseList.add(dto);
	    }

	    return responseList;
	}

	@Override
	public SprintResponseDTO getSprintById(Long id) {
		Sprint sprint = sprintRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));

	    SprintResponseDTO dto = new SprintResponseDTO();

	    dto.setId(sprint.getId());
	    dto.setSprintNumber(sprint.getSprintNumber());
	    dto.setGoal(sprint.getGoal());

	    dto.setStatus(sprint.getStatus().name());

	    dto.setStartDate(sprint.getStartDate());
	    dto.setEndDate(sprint.getEndDate());

	    dto.setProjectId(sprint.getProject().getId());
	    dto.setProjectName(sprint.getProject().getName());

	    return dto;
	}

	@Override
	public SprintResponseDTO updateSprint(Long id, SprintRequestDTO dto) {
		Sprint sprint = sprintRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));

	    Project project = projectRepository.findById(dto.getProjectId())
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    sprint.setSprintNumber(dto.getSprintNumber());
	    sprint.setGoal(dto.getGoal());

	    sprint.setStatus(SprintStatus.valueOf(dto.getStatus()));

	    sprint.setStartDate(dto.getStartDate());
	    sprint.setEndDate(dto.getEndDate());

	    sprint.setProject(project);

	    Sprint updatedSprint = sprintRepository.save(sprint);

	    SprintResponseDTO response = new SprintResponseDTO();

	    response.setId(updatedSprint.getId());
	    response.setSprintNumber(updatedSprint.getSprintNumber());
	    response.setGoal(updatedSprint.getGoal());

	    response.setStatus(updatedSprint.getStatus().name());

	    response.setStartDate(updatedSprint.getStartDate());
	    response.setEndDate(updatedSprint.getEndDate());

	    response.setProjectId(project.getId());
	    response.setProjectName(project.getName());

	    return response;
	}

	@Override
	public void deleteSprint(Long id) {
		Sprint sprint = sprintRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));

	    sprintRepository.delete(sprint);
	}

	public SprintSummaryDTO getSprintSummary(Long sprintId) {

	    Sprint sprint = sprintRepository.findById(sprintId)
	            .orElseThrow(() ->
	            new ResourceNotFoundException(
	            "Sprint not found"));

	    SprintSummaryDTO dto =
	            new SprintSummaryDTO();

	    dto.setSprintId(sprintId);

	    int totalTasks =
	            sprint.getTasks().size();

	    dto.setTotalTasks(totalTasks);

	    int completedTasks = 0;

	    Map<String,Integer> priorityMap =
	            new HashMap<>();

	    int overdueTasks = 0;

	    for(Task task : sprint.getTasks()) {

	        if(task.getStatus() ==
	                TaskStatus.DONE) {

	            completedTasks++;
	        }

	        String priority =
	                task.getPriority().name();

	        priorityMap.put(
	                priority,
	                priorityMap.getOrDefault(
	                priority,0)+1);
	    }

	    dto.setCompletedTasks(
	            completedTasks);

	    double percentage = 0;

	    if(totalTasks > 0) {

	        percentage =
	                (completedTasks * 100.0)
	                / totalTasks;
	    }

	    dto.setCompletionPercentage(
	            percentage);

	    dto.setTasksByPriority(
	            priorityMap);

	    dto.setOverdueTasks(
	            overdueTasks);

	    return dto;
	}

}
