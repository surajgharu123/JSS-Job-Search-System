package com.jss.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBSEEKER")
public class UserJobSeekerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String name;
	private String username;
	private String password;
	private String address;
	private long contactNo;
	private String email;
	private String skillset;
	private String roles;
	private Integer jobID = null;
	
	
	
	public UserJobSeekerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserJobSeekerEntity(int id, String name, String username, String password, String address, long contactNo,
			String email, String skillset, String roles, Integer jobID) {
		super();
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

	

	@Override
	public String toString() {
		return "UserJobSeekerEntity [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", skillset=" + skillset
				+ ", roles=" + roles + ", jobID=" + jobID + "]";
	}

}
