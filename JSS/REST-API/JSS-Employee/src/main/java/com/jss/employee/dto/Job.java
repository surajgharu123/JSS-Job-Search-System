package com.jss.employee.dto;

public class Job {
	
	private Integer id;
	private String job_title;
	private String location;
	private String description;
	private int experience;
	private double salary;
	private int notice;
	private long contact_no;
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
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", job_title=" + job_title + ", location=" + location + ", description=" + description
				+ ", experience=" + experience + ", salary=" + salary + ", notice=" + notice + ", contact_no="
				+ contact_no + ", status=" + status + "]";
	}
	
	public Job(Integer id, String job_title, String location, String description, int experience, double salary, int notice,
			long contact_no, String status) {
		
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
	public Job() {
		
	}
	


}
