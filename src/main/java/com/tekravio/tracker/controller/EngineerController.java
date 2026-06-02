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

import com.tekravio.tracker.dto.AvailableEngineerDTO;
import com.tekravio.tracker.dto.EngineerRequestDTO;
import com.tekravio.tracker.dto.EngineerResponseDTO;
import com.tekravio.tracker.dto.EngineerWorkloadDTO;
import com.tekravio.tracker.service.EngineerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/engineers")
public class EngineerController {
	
	@Autowired
    private EngineerService engineerService;

    @PostMapping
    public EngineerResponseDTO createEngineer(
            @Valid @RequestBody EngineerRequestDTO dto) {

        return engineerService.createEngineer(dto);
    }
    
    @GetMapping
    public List<EngineerResponseDTO> getAllEngineers() {
        return engineerService.getAllEngineers();
    }
    
    @GetMapping("/{id}")
    public EngineerResponseDTO getEngineerById(
            @PathVariable Long id) {

        return engineerService.getEngineerById(id);
    }
    
    @PutMapping("/{id}")
    public EngineerResponseDTO updateEngineer(
            @PathVariable Long id,
            @Valid @RequestBody EngineerRequestDTO dto) {

        return engineerService.updateEngineer(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public String deleteEngineer(@PathVariable Long id) {

        engineerService.deleteEngineer(id);

        return "Engineer deleted successfully";
    }
    
    @GetMapping("/{id}/workload")
    public EngineerWorkloadDTO getEngineerWorkload(
            @PathVariable Long id) {

        return engineerService
                .getEngineerWorkload(id);
    }
    
    @GetMapping("/available")
    public List<AvailableEngineerDTO>
    getAvailableEngineers(
            @RequestParam String stack) {

        return engineerService
                .getAvailableEngineers(stack);
    }
}
