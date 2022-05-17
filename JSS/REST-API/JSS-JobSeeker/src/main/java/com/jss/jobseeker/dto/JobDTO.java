package com.jss.jobseeker.dto;

import java.util.List;

public class JobDTO {
	
	private int Id;
	private String jobTitle;
	private String location;
	private String description;
	private Integer experience;
	private Double salary;
	private Integer noticePeriod;
	private String ContactEmail;
	private String Status;
	private String skills;
	private String companyName;
	
	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public JobDTO(int id, String jobTitle, String location, String description, Integer experience, Double salary,
			Integer noticePeriod, String contactEmail, String status, String skills, String companyName) {
		super();
		Id = id;
		this.jobTitle = jobTitle;
		this.location = location;
		this.description = description;
		this.experience = experience;
		this.salary = salary;
		this.noticePeriod = noticePeriod;
		ContactEmail = contactEmail;
		Status = status;
		this.skills = skills;
		this.companyName = companyName;
	}




	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getContactEmail() {
		return ContactEmail;
	}

	public void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	@Override
	public String toString() {
		return "JobSeekerDTO [Id=" + Id + ", jobTitle=" + jobTitle + ", location=" + location + ", description="
				+ description + ", experience=" + experience + ", salary=" + salary + ", noticePeriod=" + noticePeriod
				+ ", ContactEmail=" + ContactEmail + ", Status=" + Status + ", skills=" + skills + ", companyName="
				+ companyName + "]";
	}

	


	

}
