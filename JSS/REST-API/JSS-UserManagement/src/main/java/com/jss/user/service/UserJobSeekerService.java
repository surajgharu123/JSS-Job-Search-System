package com.jss.user.service;

import com.jss.user.dto.UserJobSeekerDTO;

public interface UserJobSeekerService {

	UserJobSeekerDTO registerUserJobSeeker(UserJobSeekerDTO userJobDTO);

	String authenticateUserJobLogin(UserJobSeekerDTO userJobDTO);

	Boolean validationAuthToken(String authToken);

}
