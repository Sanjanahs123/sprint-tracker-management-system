package com.tekravio.tracker.dto;

public class AvailableEngineerDTO {
	private Long engineerId;

    private String engineerName;

    private String primaryStack;

    private int activeTasks;

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

	public String getPrimaryStack() {
		return primaryStack;
	}

	public void setPrimaryStack(String primaryStack) {
		this.primaryStack = primaryStack;
	}

	public int getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(int activeTasks) {
		this.activeTasks = activeTasks;
	}
    
    
}
