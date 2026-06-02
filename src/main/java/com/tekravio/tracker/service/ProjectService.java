package com.tekravio.tracker.service;
import java.util.List;

import com.tekravio.tracker.dto.ProjectHealthDTO;
import com.tekravio.tracker.dto.ProjectRequestDTO;
import com.tekravio.tracker.dto.ProjectResponseDTO;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO dto);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Long id);

    ProjectResponseDTO updateProject(Long id,
                                     ProjectRequestDTO dto);

    void deleteProject(Long id);
    
    ProjectHealthDTO getProjectHealth(Long projectId);
}
