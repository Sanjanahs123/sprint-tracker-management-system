package com.tekravio.tracker.dto;

public class ProjectHealthDTO {
	 	private Long projectId;

	    private String projectName;

	    private double completionRate;

	    private int overdueTasks;

	    private int healthScore;

	    private String status;

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

		public double getCompletionRate() {
			return completionRate;
		}

		public void setCompletionRate(double completionRate) {
			this.completionRate = completionRate;
		}

		public int getOverdueTasks() {
			return overdueTasks;
		}

		public void setOverdueTasks(int overdueTasks) {
			this.overdueTasks = overdueTasks;
		}

		public int getHealthScore() {
			return healthScore;
		}

		public void setHealthScore(int healthScore) {
			this.healthScore = healthScore;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}
