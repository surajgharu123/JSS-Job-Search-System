package com.jss.user.service;

import com.jss.user.dto.UserDTO;

public interface UserService {
	
	
	public String authenticateEmployee(UserDTO login);
	public UserDTO getUserRegistration( UserDTO login);
	public UserDTO createEmployee(String authToken);

}
