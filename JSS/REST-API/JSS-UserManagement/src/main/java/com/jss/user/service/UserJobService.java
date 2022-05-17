package com.jss.user.service;

import com.jss.user.dto.UserJobDTO;

public interface UserJobService {

	UserJobDTO registerUserJobSeeker(UserJobDTO userJobDTO);

	String authenticateUserJobLogin(UserJobDTO userJobDTO);

}
