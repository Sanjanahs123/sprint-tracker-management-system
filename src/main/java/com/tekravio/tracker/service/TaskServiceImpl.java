package com.tekravio.tracker.service;
import java.util.ArrayList;
import com.tekravio.tracker.exception.InvalidStatusTransitionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekravio.tracker.dto.TaskRequestDTO;
import com.tekravio.tracker.dto.TaskResponseDTO;
import com.tekravio.tracker.exception.EngineerNotAvailableException;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import com.tekravio.tracker.model.Engineer;
import com.tekravio.tracker.model.Sprint;
import com.tekravio.tracker.model.Task;
import com.tekravio.tracker.model.TaskPriority;
import com.tekravio.tracker.model.TaskStatus;
import com.tekravio.tracker.repository.EngineerRepository;
import com.tekravio.tracker.repository.SprintRepository;
import com.tekravio.tracker.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private EngineerRepository engineerRepository;

	@Override
	public TaskResponseDTO createTask(TaskRequestDTO dto) {
		Sprint sprint = sprintRepository.findById(dto.getSprintId())
	            .orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));

	    Engineer engineer = engineerRepository.findById(dto.getEngineerId())
	            .orElseThrow(() -> new ResourceNotFoundException("Engineer not found"));
	    
	    if (!engineer.getIsAvailable()) {

	        throw new EngineerNotAvailableException(
	                "Engineer is not available");
	    }

	    Task task = new Task();

	    task.setTitle(dto.getTitle());
	    task.setDescription(dto.getDescription());

	    task.setPriority(
	            TaskPriority.valueOf(dto.getPriority()));

	    task.setStatus(
	            TaskStatus.valueOf(dto.getStatus()));

	    task.setEstimatedHours(dto.getEstimatedHours());
	    task.setActualHours(dto.getActualHours());

	    task.setSprint(sprint);
	    task.setAssignedEngineer(engineer);

	    Task savedTask = taskRepository.save(task);

	    TaskResponseDTO response = new TaskResponseDTO();

	    response.setId(savedTask.getId());
	    response.setTitle(savedTask.getTitle());
	    response.setDescription(savedTask.getDescription());

	    response.setPriority(
	            savedTask.getPriority().name());

	    response.setStatus(
	            savedTask.getStatus().name());

	    response.setEstimatedHours(
	            savedTask.getEstimatedHours());

	    response.setActualHours(
	            savedTask.getActualHours());

	    response.setSprintId(
	            sprint.getId());

	    response.setSprintNumber(
	            sprint.getSprintNumber());

	    response.setEngineerId(
	            engineer.getId());

	    response.setEngineerName(
	            engineer.getName());

	    return response;
	}

	@Override
	public List<TaskResponseDTO> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();

	    List<TaskResponseDTO> responseList = new ArrayList<>();

	    for (Task task : tasks) {

	        TaskResponseDTO dto = new TaskResponseDTO();

	        dto.setId(task.getId());
	        dto.setTitle(task.getTitle());
	        dto.setDescription(task.getDescription());

	        dto.setPriority(task.getPriority().name());
	        dto.setStatus(task.getStatus().name());

	        dto.setEstimatedHours(task.getEstimatedHours());
	        dto.setActualHours(task.getActualHours());

	        dto.setSprintId(task.getSprint().getId());
	        dto.setSprintNumber(task.getSprint().getSprintNumber());

	        dto.setEngineerId(task.getAssignedEngineer().getId());
	        dto.setEngineerName(task.getAssignedEngineer().getName());

	        responseList.add(dto);
	    }

	    return responseList;
	}

	@Override
	public TaskResponseDTO getTaskById(Long id) {
		Task task = taskRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

	    TaskResponseDTO dto = new TaskResponseDTO();

	    dto.setId(task.getId());
	    dto.setTitle(task.getTitle());
	    dto.setDescription(task.getDescription());

	    dto.setPriority(task.getPriority().name());
	    dto.setStatus(task.getStatus().name());

	    dto.setEstimatedHours(task.getEstimatedHours());
	    dto.setActualHours(task.getActualHours());

	    dto.setSprintId(task.getSprint().getId());
	    dto.setSprintNumber(task.getSprint().getSprintNumber());

	    dto.setEngineerId(task.getAssignedEngineer().getId());
	    dto.setEngineerName(task.getAssignedEngineer().getName());

	    return dto;
	}

	@Override
	public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
		Task task = taskRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

	    Sprint sprint = sprintRepository.findById(dto.getSprintId())
	            .orElseThrow(() -> new ResourceNotFoundException("Sprint not found"));

	    Engineer engineer = engineerRepository.findById(dto.getEngineerId())
	            .orElseThrow(() -> new ResourceNotFoundException("Engineer not found"));
	    
	    if (!engineer.getIsAvailable()) {

	        throw new EngineerNotAvailableException(
	                "Engineer is not available");
	    }

	    task.setTitle(dto.getTitle());
	    task.setDescription(dto.getDescription());

	    task.setPriority(TaskPriority.valueOf(dto.getPriority()));
	    TaskStatus currentStatus =
	            task.getStatus();

	    TaskStatus newStatus =
	            TaskStatus.valueOf(dto.getStatus());

	    boolean validTransition = false;

	    if (currentStatus == TaskStatus.TODO
	            && newStatus == TaskStatus.IN_PROGRESS) {

	        validTransition = true;
	    }
	    else if (currentStatus == TaskStatus.IN_PROGRESS
	            && newStatus == TaskStatus.REVIEW) {

	        validTransition = true;
	    }
	    else if (currentStatus == TaskStatus.REVIEW
	            && newStatus == TaskStatus.DONE) {

	        validTransition = true;
	    }
	    else if (currentStatus == newStatus) {

	        validTransition = true;
	    }

	    if (!validTransition) {

	        throw new InvalidStatusTransitionException(
	                "Invalid task status transition");
	    }

	    task.setStatus(newStatus);

	    task.setEstimatedHours(dto.getEstimatedHours());
	    task.setActualHours(dto.getActualHours());

	    task.setSprint(sprint);
	    task.setAssignedEngineer(engineer);

	    Task updatedTask = taskRepository.save(task);

	    TaskResponseDTO response = new TaskResponseDTO();

	    response.setId(updatedTask.getId());
	    response.setTitle(updatedTask.getTitle());
	    response.setDescription(updatedTask.getDescription());

	    response.setPriority(updatedTask.getPriority().name());
	    response.setStatus(updatedTask.getStatus().name());

	    response.setEstimatedHours(updatedTask.getEstimatedHours());
	    response.setActualHours(updatedTask.getActualHours());

	    response.setSprintId(sprint.getId());
	    response.setSprintNumber(sprint.getSprintNumber());

	    response.setEngineerId(engineer.getId());
	    response.setEngineerName(engineer.getName());

	    return response;
	}

	@Override
	public void deleteTask(Long id) {
		Task task = taskRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

	    taskRepository.delete(task);
	}
	
	@Override
	public List<TaskResponseDTO> filterTasks(
	        String status,
	        String priority,
	        Long sprintId) {

	    List<Task> tasks =
	            taskRepository
	            .findByStatusAndPriorityAndSprintId(
	            TaskStatus.valueOf(status),
	            TaskPriority.valueOf(priority),
	            sprintId);

	    List<TaskResponseDTO> result =
	            new ArrayList<>();

	    for(Task task : tasks) {

	        TaskResponseDTO dto =
	                new TaskResponseDTO();

	        dto.setId(task.getId());
	        dto.setTitle(task.getTitle());
	        dto.setDescription(task.getDescription());

	        dto.setPriority(
	                task.getPriority().name());

	        dto.setStatus(
	                task.getStatus().name());

	        dto.setEstimatedHours(
	                task.getEstimatedHours());

	        dto.setActualHours(
	                task.getActualHours());

	        dto.setSprintId(
	                task.getSprint().getId());
	        
	        dto.setSprintNumber(
	                task.getSprint().getSprintNumber());

	        dto.setEngineerId(
	                task.getAssignedEngineer().getId());

	        dto.setEngineerName(
	                task.getAssignedEngineer().getName());
	        
	        result.add(dto);
	    }

	    return result;
	}

}
