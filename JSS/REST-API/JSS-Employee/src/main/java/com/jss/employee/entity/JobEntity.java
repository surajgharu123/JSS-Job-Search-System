package com.jss.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "JOB")
@ApiModel(value="JOB DTO")
public class JobEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty("Job ID")
	private Integer id;
	@ApiModelProperty("Job Title")
	private String job_title;
	@ApiModelProperty("Job Location")
	private String location;
	@ApiModelProperty("Job Description")
	private String description;
	@ApiModelProperty("Job Experience")
	private int experience;
	@ApiModelProperty("Job Salary")
	private double salary;
	@ApiModelProperty("Job Notice Period")
	private int notice;
	@ApiModelProperty("Contact Number")
	private long contact_no;
	@ApiModelProperty("Job Status")
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public JobEntity() {
		
	}
	
	public JobEntity(Integer id, String job_title, String location, String description, int experience, double salary,
			int notice, long contact_no, String status) {
	
		this.id = id;
		this.job_title = job_title;
		this.location = location;
		this.description = description;
		this.experience = experience;
		this.salary = salary;
		this.notice = notice;
		this.contact_no = contact_no;
		this.status = status;
	}
	@Override
	public String toString() {
		return "JobEntity [id=" + id + ", job_title=" + job_title + ", location=" + location + ", description="
				+ description + ", experience=" + experience + ", salary=" + salary + ", notice=" + notice
				+ ", contact_no=" + contact_no + ", status=" + status + "]";
	}

	

}
