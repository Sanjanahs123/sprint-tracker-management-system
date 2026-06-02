package com.tekravio.tracker.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "engineers")
public class Engineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private PrimaryStack primaryStack;

    private Integer experienceYears;
    
    @OneToMany(mappedBy = "assignedEngineer")
    private List<Task> tasks;

    public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	private Boolean isAvailable;

    public Engineer() {
    }

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

	public PrimaryStack getPrimaryStack() {
		return primaryStack;
	}

	public void setPrimaryStack(PrimaryStack primaryStack) {
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
