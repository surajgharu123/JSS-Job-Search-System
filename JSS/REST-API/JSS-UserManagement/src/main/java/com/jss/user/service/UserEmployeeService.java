package com.jss.user.service;

import com.jss.user.dto.UserEmployeeDTO;

public interface UserEmployeeService {
	
	
	public String authenticateEmployee(UserEmployeeDTO login);
	public UserEmployeeDTO getUserRegistration( UserEmployeeDTO login);
	public UserEmployeeDTO createEmployee(String authToken);
	public Boolean validationAuthToken(String authToken);

}
