package com.jss.user.dto;

public class UserEmployeeDTO {

	private int id;
	private String userName;
	private String password;
	private String orgnizationName;
	
	private String address;
	private String jobTitle;
	private String location;
	private String description;
	private int experience;
	private int salary;
	private int noticePeriod;
	private int contact;
	private String email;
	private String status;
	private String role;
	

	public UserEmployeeDTO() {
	}
	
	public UserEmployeeDTO(int id, String userName, String password, String orgnizationName, String address, String jobTitle,
			String location, String description, int experience, int salary, int noticePeriod, int contact,
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
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
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
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", orgnizationName="
				+ orgnizationName + ", address=" + address + ", jobTitle=" + jobTitle + ", location=" + location
				+ ", description=" + description + ", experience=" + experience + ", salary=" + salary
				+ ", noticePeriod=" + noticePeriod + ", contact=" + contact + ", email=" + email + ", status=" + status
				+ ", role=" + role + "]";
	}
	
//	public UserDTO(String userName, String password) {
//		super();
//		this.userName = userName;
//		this.password = password;
//	}
//	
	
	
}
