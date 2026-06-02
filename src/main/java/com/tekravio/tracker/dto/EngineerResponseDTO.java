package com.tekravio.tracker.dto;

public class EngineerResponseDTO {
	private Long id;

    private String name;
    private String email;
    private String primaryStack;
    private Integer experienceYears;
    private Boolean isAvailable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrimaryStack() {
		return primaryStack;
	}
	public void setPrimaryStack(String primaryStack) {
		this.primaryStack = primaryStack;
	}
	public Integer getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

    
}
