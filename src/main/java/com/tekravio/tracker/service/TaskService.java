package com.tekravio.tracker.service;
import java.util.List;

import com.tekravio.tracker.dto.TaskRequestDTO;
import com.tekravio.tracker.dto.TaskResponseDTO;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO dto);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Long id);

    TaskResponseDTO updateTask(Long id,
                               TaskRequestDTO dto);

    void deleteTask(Long id);
    
    List<TaskResponseDTO> filterTasks(
            String status,
            String priority,
            Long sprintId);
}
