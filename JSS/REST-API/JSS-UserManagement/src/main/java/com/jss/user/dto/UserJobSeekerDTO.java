package com.jss.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User Job DTO")
public class UserJobSeekerDTO {

	@ApiModelProperty(value = "JobSeeker Id")
	private int id;
	@ApiModelProperty(value = "JobSeeker Name")
	private String name;
	@ApiModelProperty(value = "JobSeeker Username")
	private String username;
	@ApiModelProperty(value = "JobSeeker Password")
	private String password;
	@ApiModelProperty(value = "JobSeeker Address")
	private String address;
	@ApiModelProperty(value = "JobSeeker Contact No")
	private long contactNo;
	@ApiModelProperty(value = "JobSeeker Email")
	private String email;
	@ApiModelProperty(value = "JobSeeker SkillSet")
	private String skillset;
	@ApiModelProperty(value = "JobSeeker Roles")
	private String roles;
	@ApiModelProperty(value = "JobSeeker JobID")
	private Integer jobID = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	public UserJobSeekerDTO(int id, String name, String username, String password, String address, long contactNo,
			String email, String skillset, String roles, Integer jodId) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.skillset = skillset;
		this.roles = roles;
		this.jobID = jobID;
	}

	public UserJobSeekerDTO() {

	}

	@Override
	public String toString() {
		return "UserJobSeekerDTO [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", skillset=" + skillset
				+ ", roles=" + roles + ", jobID=" + jobID + "]";
	}
	
}
