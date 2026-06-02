package com.tekravio.tracker.dto;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SprintRequestDTO {

    @NotNull(message = "Sprint number is required")
    private Integer sprintNumber;

    @NotBlank(message = "Goal cannot be empty")
    private String goal;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Project ID is required")
    private Long projectId;

	public Integer getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(Integer sprintNumber) {
		this.sprintNumber = sprintNumber;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

    
}
