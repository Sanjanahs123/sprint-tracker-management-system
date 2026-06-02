package com.tekravio.tracker.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.tekravio.tracker.dto.AvailableEngineerDTO;
import com.tekravio.tracker.dto.EngineerWorkloadDTO;
import com.tekravio.tracker.model.Task;
import com.tekravio.tracker.model.TaskStatus;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekravio.tracker.dto.EngineerRequestDTO;
import com.tekravio.tracker.dto.EngineerResponseDTO;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import com.tekravio.tracker.model.Engineer;
import com.tekravio.tracker.model.PrimaryStack;
import com.tekravio.tracker.repository.EngineerRepository;



import com.tekravio.tracker.dto.AvailableEngineerDTO;

@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;
    
	@Override
	public EngineerResponseDTO createEngineer(EngineerRequestDTO dto) {
		Engineer engineer = new Engineer();

	    engineer.setName(dto.getName());
	    engineer.setEmail(dto.getEmail());

	    engineer.setPrimaryStack(
	            PrimaryStack.valueOf(dto.getPrimaryStack()));

	    engineer.setExperienceYears(
	            dto.getExperienceYears());

	    engineer.setIsAvailable(dto.getIsAvailable());

	    Engineer savedEngineer =
	            engineerRepository.save(engineer);

	    EngineerResponseDTO response =
	            new EngineerResponseDTO();

	    response.setId(savedEngineer.getId());
	    response.setName(savedEngineer.getName());
	    response.setEmail(savedEngineer.getEmail());

	    response.setPrimaryStack(
	            savedEngineer.getPrimaryStack().name());

	    response.setExperienceYears(
	            savedEngineer.getExperienceYears());

	    response.setIsAvailable(
	            savedEngineer.getIsAvailable());

	    return response;
	}

	@Override
	public List<EngineerResponseDTO> getAllEngineers() {
		List<Engineer> engineers = engineerRepository.findAll();

	    List<EngineerResponseDTO> responseList = new ArrayList<>();

	    for (Engineer engineer : engineers) {

	        EngineerResponseDTO dto = new EngineerResponseDTO();

	        dto.setId(engineer.getId());
	        dto.setName(engineer.getName());
	        dto.setEmail(engineer.getEmail());

	        dto.setPrimaryStack(
	                engineer.getPrimaryStack().name());

	        dto.setExperienceYears(
	                engineer.getExperienceYears());

	        dto.setIsAvailable(
	                engineer.getIsAvailable());

	        responseList.add(dto);
	    }

	    return responseList;
	}

	@Override
	public EngineerResponseDTO getEngineerById(Long id) {
		Engineer engineer = engineerRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Engineer not found"));

	    EngineerResponseDTO dto = new EngineerResponseDTO();

	    dto.setId(engineer.getId());
	    dto.setName(engineer.getName());
	    dto.setEmail(engineer.getEmail());

	    dto.setPrimaryStack(
	            engineer.getPrimaryStack().name());

	    dto.setExperienceYears(
	            engineer.getExperienceYears());

	    dto.setIsAvailable(
	            engineer.getIsAvailable());

	    return dto;
	}

	@Override
	public EngineerResponseDTO updateEngineer(Long id, EngineerRequestDTO dto) {
		Engineer engineer = engineerRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Engineer not found"));

	    engineer.setName(dto.getName());
	    engineer.setEmail(dto.getEmail());

	    engineer.setPrimaryStack(
	            PrimaryStack.valueOf(dto.getPrimaryStack()));

	    engineer.setExperienceYears(
	            dto.getExperienceYears());

	    engineer.setIsAvailable(
	            dto.getIsAvailable());

	    Engineer updatedEngineer =
	            engineerRepository.save(engineer);

	    EngineerResponseDTO response =
	            new EngineerResponseDTO();

	    response.setId(updatedEngineer.getId());
	    response.setName(updatedEngineer.getName());
	    response.setEmail(updatedEngineer.getEmail());

	    response.setPrimaryStack(
	            updatedEngineer.getPrimaryStack().name());

	    response.setExperienceYears(
	            updatedEngineer.getExperienceYears());

	    response.setIsAvailable(
	            updatedEngineer.getIsAvailable());

	    return response;
	}

	@Override
	public void deleteEngineer(Long id) {
		 Engineer engineer = engineerRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Engineer not found"));

		    engineerRepository.delete(engineer);
		
	}
	
	@Override
	public EngineerWorkloadDTO getEngineerWorkload(Long engineerId) {

	    Engineer engineer = engineerRepository.findById(engineerId)
	            .orElseThrow(() ->
	            new ResourceNotFoundException(
	            "Engineer not found"));

	    EngineerWorkloadDTO dto =
	            new EngineerWorkloadDTO();

	    dto.setEngineerId(engineer.getId());
	    dto.setEngineerName(engineer.getName());

	    int activeTasks = 0;

	    int totalEstimatedHours = 0;
	    int totalActualHours = 0;

	    Map<String,Integer> tasksByStatus =
	            new HashMap<>();

	    for(Task task : engineer.getTasks()) {

	        String status =
	                task.getStatus().name();

	        tasksByStatus.put(
	                status,
	                tasksByStatus.getOrDefault(
	                status,0)+1);

	        if(task.getStatus() != TaskStatus.DONE) {
	            activeTasks++;
	        }

	        totalEstimatedHours +=
	                task.getEstimatedHours();

	        totalActualHours +=
	                task.getActualHours();
	    }

	    dto.setActiveTasks(activeTasks);

	    dto.setTasksByStatus(tasksByStatus);

	    dto.setTotalEstimatedHours(
	            totalEstimatedHours);

	    dto.setTotalActualHours(
	            totalActualHours);

	    return dto;
	}
	
	public List<AvailableEngineerDTO> getAvailableEngineers(String stack) {

	    PrimaryStack primaryStack =
	            PrimaryStack.valueOf(stack);

	    List<Engineer> engineers =
	            engineerRepository
	            .findByPrimaryStackAndIsAvailable(
	            primaryStack,
	            true);

	    List<AvailableEngineerDTO> result =
	            new ArrayList<>();

	    for(Engineer engineer : engineers) {

	        int activeTasks = 0;

	        for(Task task : engineer.getTasks()) {

	            if(task.getStatus() != TaskStatus.DONE) {

	                activeTasks++;
	            }
	        }

	        if(activeTasks < 3) {

	            AvailableEngineerDTO dto =
	                    new AvailableEngineerDTO();

	            dto.setEngineerId(
	                    engineer.getId());

	            dto.setEngineerName(
	                    engineer.getName());

	            dto.setPrimaryStack(
	                    engineer.getPrimaryStack()
	                    .name());

	            dto.setActiveTasks(
	                    activeTasks);

	            result.add(dto);
	        }
	    }

	    return result;
	}

}
