package com.tekravio.tracker.dto;

import java.util.Map;

public class SprintSummaryDTO {
	private Long sprintId;

    private int totalTasks;

    private int completedTasks;

    private double completionPercentage;

    private Map<String,Integer> tasksByPriority;

    private int overdueTasks;

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public double getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(double completionPercentage) {
		this.completionPercentage = completionPercentage;
	}

	public Map<String, Integer> getTasksByPriority() {
		return tasksByPriority;
	}

	public void setTasksByPriority(Map<String, Integer> tasksByPriority) {
		this.tasksByPriority = tasksByPriority;
	}

	public int getOverdueTasks() {
		return overdueTasks;
	}

	public void setOverdueTasks(int overdueTasks) {
		this.overdueTasks = overdueTasks;
	}
    
    
}
