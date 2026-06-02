package com.tekravio.tracker.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
	
	@NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Industry cannot be empty")
    private String industry;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Country cannot be empty")
    private String country;

    public ClientRequestDTO() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
    
}
