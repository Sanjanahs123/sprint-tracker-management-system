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

import com.tekravio.tracker.dto.SprintRequestDTO;
import com.tekravio.tracker.dto.SprintResponseDTO;
import com.tekravio.tracker.dto.SprintSummaryDTO;
import com.tekravio.tracker.service.SprintService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {
	@Autowired
    private SprintService sprintService;

    @PostMapping
    public SprintResponseDTO createSprint(
    		@Valid @RequestBody SprintRequestDTO dto) {

        return sprintService.createSprint(dto);
    }
    
    @GetMapping
    public List<SprintResponseDTO> getAllSprints() {
        return sprintService.getAllSprints();
    }
    
    @GetMapping("/{id}")
    public SprintResponseDTO getSprintById(@PathVariable Long id) {

        return sprintService.getSprintById(id);
    }
    
    @PutMapping("/{id}")
    public SprintResponseDTO updateSprint(
            @PathVariable Long id,
            @Valid @RequestBody SprintRequestDTO dto) {

        return sprintService.updateSprint(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public String deleteSprint(@PathVariable Long id) {

        sprintService.deleteSprint(id);

        return "Sprint deleted successfully";
    }
    
    @GetMapping("/{id}/summary")
    public SprintSummaryDTO
    getSprintSummary(
            @PathVariable Long id) {

        return sprintService
                .getSprintSummary(id);
    }
}
