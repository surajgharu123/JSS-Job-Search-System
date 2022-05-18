package com.jss.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String userName;
	private String password;
	private String orgnizationName;
	private String address;
	private String jobTitle;
	private String location;
	private String description;
	private String experience;
	private String salary;
	private String noticePeriod;
	private String contact;
	private String email;
	private String status;
	public EmployeeEntity(int id, String userName, String password, String orgnizationName, String address,
			String jobTitle, String location, String description, String experience, String salary, String noticePeriod,
			String contact, String email, String status) {
		super();
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
	}
	public EmployeeEntity() {
		super();
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
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
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", orgnizationName="
				+ orgnizationName + ", address=" + address + ", jobTitle=" + jobTitle + ", location=" + location
				+ ", description=" + description + ", experience=" + experience + ", salary=" + salary
				+ ", noticePeriod=" + noticePeriod + ", contact=" + contact + ", email=" + email + ", status=" + status
				+ "]";
	}
	
	

}
