package com.jss.user.service;

import com.jss.user.dto.UserJobSeekerDTO;

public interface UserJobSeekerService {

	UserJobSeekerDTO registerUserJobSeeker(UserJobSeekerDTO userJobDTO);

	String authenticateUserJobLogin(UserJobSeekerDTO userJobDTO);

	public Boolean validationAuthToken(String authToken);
	
	public String getUsername(String authToken);
}
