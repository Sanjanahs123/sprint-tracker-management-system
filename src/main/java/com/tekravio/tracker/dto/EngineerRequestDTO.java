package com.tekravio.tracker.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class EngineerRequestDTO {
	
	@NotBlank(message = "Name cannot be empty")
    private String name;
	
	@Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;
	
	@NotBlank(message = "Primary stack is required")
    private String primaryStack;
	
	@NotNull(message = "Experience is required")
    private Integer experienceYears;
	
	@NotNull(message = "Availability is required")
    private Boolean isAvailable;
	
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
