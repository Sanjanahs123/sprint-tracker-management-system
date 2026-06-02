package com.tekravio.tracker.service;
import java.util.List;

import com.tekravio.tracker.dto.AvailableEngineerDTO;
import com.tekravio.tracker.dto.EngineerRequestDTO;
import com.tekravio.tracker.dto.EngineerResponseDTO;
import com.tekravio.tracker.dto.EngineerWorkloadDTO;

public interface EngineerService {

    EngineerResponseDTO createEngineer(EngineerRequestDTO dto);

    List<EngineerResponseDTO> getAllEngineers();

    EngineerResponseDTO getEngineerById(Long id);

    EngineerResponseDTO updateEngineer(Long id,
                                       EngineerRequestDTO dto);

    void deleteEngineer(Long id);
    
    EngineerWorkloadDTO getEngineerWorkload(Long engineerId);
    
    List<AvailableEngineerDTO> getAvailableEngineers(String stack);
}
