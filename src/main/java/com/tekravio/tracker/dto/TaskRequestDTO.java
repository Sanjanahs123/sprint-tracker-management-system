package com.tekravio.tracker.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRequestDTO {
	 @NotBlank(message = "Title cannot be empty")
	 private String title;

	 @NotBlank(message = "Description cannot be empty")
	 private String description;

	 @NotBlank(message = "Priority is required")
	 private String priority;

	 @NotBlank(message = "Status is required")
	 private String status;

	 @NotNull(message = "Estimated hours is required")
	 private Integer estimatedHours;

    @NotNull(message = "Actual hours is required")
	private Integer actualHours;

	@NotNull(message = "Sprint ID is required")
    private Long sprintId;

	@NotNull(message = "Engineer ID is required")
	private Long engineerId;
	    
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
	public Long getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(Long engineerId) {
		this.engineerId = engineerId;
	}
    
    
}
