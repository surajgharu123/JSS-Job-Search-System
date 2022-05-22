package com.jss.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Employee")
@ApiModel(value = "Employee DTO")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty("Employee ID")
	private int id;

	@ApiModelProperty("Employee Username")
	private String userName;

	@ApiModelProperty("Employee Password")
	private String password;

	@ApiModelProperty("Employee Orgnization Name")
	private String orgnizationName;
	
	@ApiModelProperty("Employee Address")
	private String address;
	@ApiModelProperty("Employee Job Title")
	private String jobTitle;
	@ApiModelProperty("Employee Location")
	private String location;
	@ApiModelProperty("Employee Description")
	private String description;
	
	@ApiModelProperty("Employee Experience")
	private int experience;
	@ApiModelProperty("Employee Salary")
	private int salary;
	@ApiModelProperty("Employee Notice Period")
	private int noticePeriod;
	@ApiModelProperty("Employee Contact Number")
	private long contact;
	@ApiModelProperty("Employee Email")
	private String email;
	@ApiModelProperty("Employee Status")
	private String status;
	@ApiModelProperty("Employee Role")
	private String role;
	

	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(int id, String userName, String password, String orgnizationName, String address, String jobTitle,
			String location, String description, int experience, int salary, int noticePeriod, long contact,
			String email, String status, String role) {
	
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.orgnizationName = orgnizationName;
		this.address = address;
		this.jobTitle = jobTitle;
		this.location = location;
		this.description = description;
		this.experience = experience;
		this.salary = salary;
		this.noticePeriod = noticePeriod;
		this.contact = contact;
		this.email = email;
		this.status = status;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrgnizationName() {
		return orgnizationName;
	}
	public void setOrgnizationName(String orgnizationName) {
		this.orgnizationName = orgnizationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", orgnizationName="
				+ orgnizationName + ", address=" + address + ", jobTitle=" + jobTitle + ", location=" + location
				+ ", description=" + description + ", experience=" + experience + ", salary=" + salary
				+ ", noticePeriod=" + noticePeriod + ", contact=" + contact + ", email=" + email + ", status=" + status
				+ ", role=" + role + "]";
	}
	
	
	

}
