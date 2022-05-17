package com.jss.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="jobseeker")
public class JobSeekerEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty("Jobseeker ID")
	private int id;
	@ApiModelProperty("Jobseeker Name")
	private String name;
	@ApiModelProperty("Jobseeker Username")
	private String username;
	@ApiModelProperty("Jobseeker Password")
	private String password;
	@ApiModelProperty("Jobseeker Address")
	private String address;
	@ApiModelProperty("Jobseeker Contact Number")
	private long contactNo;
	@ApiModelProperty("Jobseeker Email")
	private String email;
	@ApiModelProperty("Jobseeker skillset")
	private String skillset;

	
	public JobSeekerEntity(int id, String name, String username, String password, String address, long contactNo,
			String email, String skillset) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.skillset = skillset;
	}
	
	

	public JobSeekerEntity() {
		super();
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

	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", skillset=" + skillset
				+ "]";
	}
	
	

}
