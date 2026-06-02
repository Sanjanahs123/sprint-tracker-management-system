package com.tekravio.tracker.service;
import java.util.List;

import com.tekravio.tracker.dto.SprintRequestDTO;
import com.tekravio.tracker.dto.SprintResponseDTO;
import com.tekravio.tracker.dto.SprintSummaryDTO;

public interface SprintService {

    SprintResponseDTO createSprint(SprintRequestDTO dto);

    List<SprintResponseDTO> getAllSprints();

    SprintResponseDTO getSprintById(Long id);

    SprintResponseDTO updateSprint(Long id,
                                   SprintRequestDTO dto);

    void deleteSprint(Long id);
    
    SprintSummaryDTO getSprintSummary(Long sprintId);
}
