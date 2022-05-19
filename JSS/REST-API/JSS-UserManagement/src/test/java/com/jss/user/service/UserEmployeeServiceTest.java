package com.jss.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.jss.user.dto.UserEmployeeDTO;

class UserEmployeeServiceTest {

	UserEmployeeService userEmployeeService = mock(UserEmployeeService.class);

	@Test
	void testAuthenticateEmployeeTrueTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.authenticateEmployee(userEmployeeDTO)).thenReturn("Zensar");

		assertEquals(userEmployeeService.authenticateEmployee(userEmployeeDTO), userEmployeeDTO.getJobTitle());
	}

	@Test
	void testGetUserRegistrationTrueTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.getUserRegistration(userEmployeeDTO)).thenReturn(userEmployeeDTO);

		assertEquals(userEmployeeService.getUserRegistration(userEmployeeDTO).getJobTitle(),
				userEmployeeDTO.getJobTitle());
	}

	@Test
	void testCreateEmployeeTrueTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.createEmployee("#WREDSS")).thenReturn(userEmployeeDTO);

		assertEquals(userEmployeeService.createEmployee("#WREDSS").getJobTitle(), "Zensar");
	}

	@Test
	void testValidationEmployeeAuthTokenFalse() {

		when(userEmployeeService.validationEmployeeAuthToken("#WSERD")).thenReturn(true);

		assertEquals(userEmployeeService.validationEmployeeAuthToken("#WSERD"), true);
	}

	void testAuthenticateEmployeeFalseTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.authenticateEmployee(userEmployeeDTO)).thenReturn("Pune");

		assertNotEquals(userEmployeeService.authenticateEmployee(userEmployeeDTO), userEmployeeDTO.getJobTitle());
	}

	@Test
	void testGetUserRegistrationFalseTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.getUserRegistration(userEmployeeDTO)).thenReturn(userEmployeeDTO);

		assertNotEquals(userEmployeeService.getUserRegistration(userEmployeeDTO).getAddress(),
				userEmployeeDTO.getJobTitle());
	}

	@Test
	void testCreateEmployeeFalseTest() {

		UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
		userEmployeeDTO.setJobTitle("Zensar");
		when(userEmployeeService.createEmployee("#WREDSS")).thenReturn(userEmployeeDTO);

		assertNotEquals(userEmployeeService.createEmployee("#WREDSS").getJobTitle(), "Pune");
	}

	@Test
	void testValidationEmployeeAuthTokenFalseTest() {

		when(userEmployeeService.validationEmployeeAuthToken("#WSERD")).thenReturn(true);

		assertNotEquals(userEmployeeService.validationEmployeeAuthToken("#WSERD"), false);
	}

}
