package com.tekravio.tracker.dto;

public class TaskResponseDTO {
	private Long id;

    private String title;
    private String description;

    private String priority;
    private String status;

    private Integer estimatedHours;
    private Integer actualHours;

    private Long sprintId;
    private Integer sprintNumber;

    private Long engineerId;
    private String engineerName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Integer getActualHours() {
		return actualHours;
	}
	public void setActualHours(Integer actualHours) {
		this.actualHours = actualHours;
	}
	public Long getSprintId() {
		return sprintId;
	}
	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}
	public Integer getSprintNumber() {
		return sprintNumber;
	}
	public void setSprintNumber(Integer sprintNumber) {
		this.sprintNumber = sprintNumber;
	}
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
    
    
}
