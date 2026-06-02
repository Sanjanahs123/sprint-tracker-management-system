package com.tekravio.tracker.dto;

import java.util.Map;

public class EngineerWorkloadDTO {
	private Long engineerId;
    private String engineerName;

    private int activeTasks;

    private Map<String,Integer> tasksByStatus;

    private int totalEstimatedHours;

    private int totalActualHours;

	public Long getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(Long engineerId) {
		this.engineerId = engineerId;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public int getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(int activeTasks) {
		this.activeTasks = activeTasks;
	}

	public Map<String, Integer> getTasksByStatus() {
		return tasksByStatus;
	}

	public void setTasksByStatus(Map<String, Integer> tasksByStatus) {
		this.tasksByStatus = tasksByStatus;
	}

	public int getTotalEstimatedHours() {
		return totalEstimatedHours;
	}

	public void setTotalEstimatedHours(int totalEstimatedHours) {
		this.totalEstimatedHours = totalEstimatedHours;
	}

	public int getTotalActualHours() {
		return totalActualHours;
	}

	public void setTotalActualHours(int totalActualHours) {
		this.totalActualHours = totalActualHours;
	}
    
    
}
