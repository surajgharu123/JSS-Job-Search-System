package com.jss.jobseeker.service;

public interface UserManagementDelegate {
	
	public boolean isTokenValidForEmployee(String authToken);
	public boolean isTokenValidForJobseeker(String authToken);
	public String getUserName(String authToken);
}
