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
import org.springframework.web.bind.annotation.RestController;

import com.tekravio.tracker.dto.ProjectHealthDTO;
import com.tekravio.tracker.dto.ProjectRequestDTO;
import com.tekravio.tracker.dto.ProjectResponseDTO;
import com.tekravio.tracker.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectResponseDTO createProject(
    		@Valid @RequestBody ProjectRequestDTO dto) {

        return projectService.createProject(dto);
    }
    
    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {
        return projectService.getAllProjects();
    }
    
    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(@PathVariable Long id) {

        return projectService.getProjectById(id);
    }
    
    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO dto) {

        return projectService.updateProject(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);

        return "Project deleted successfully";
    }
    
    @GetMapping("/{id}/health")
    public ProjectHealthDTO getProjectHealth(
            @PathVariable Long id) {

        return projectService
                .getProjectHealth(id);
    }
}
