package com.tekravio.tracker.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekravio.tracker.dto.TaskRequestDTO;
import com.tekravio.tracker.dto.TaskResponseDTO;
import com.tekravio.tracker.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	@Autowired
    private TaskService taskService;

    @PostMapping
    public TaskResponseDTO createTask(
    		@Valid @RequestBody TaskRequestDTO dto) {

        return taskService.createTask(dto);
    }
    
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id) {

        return taskService.getTaskById(id);
    }
    
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequestDTO dto) {

        return taskService.updateTask(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
    
    @GetMapping("/filter")
    public List<TaskResponseDTO> filterTasks(

            @RequestParam String status,

            @RequestParam String priority,

            @RequestParam Long sprintId) {

        return taskService.filterTasks(
                status,
                priority,
                sprintId);
    }
}
