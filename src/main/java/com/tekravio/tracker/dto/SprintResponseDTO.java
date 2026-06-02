package com.tekravio.tracker.dto;
import java.time.LocalDate;

public class SprintResponseDTO {

    private Long id;

    private Integer sprintNumber;
    private String goal;
    private String status;

    private LocalDate startDate;
    private LocalDate endDate;

    private Long projectId;
    private String projectName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

    
}
