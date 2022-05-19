package com.jss.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.jss.user.dto.UserJobSeekerDTO;


class UserJobSeekerServiceImpleTest {

	UserJobSeekerService userJobSeekerService = mock(UserJobSeekerService.class);
	@Test
	void testGetUsernameTrueTest() {
		
		
		when(userJobSeekerService.getUsername("#WDSRRGF")).thenReturn("Jerry");
		
		assertEquals(userJobSeekerService.getUsername("#WDSRRGF"), "Jerry");
		
	}
	
	@Test
	void testValidationAuthTokenTrueTest() {
		
		when(userJobSeekerService.validationAuthToken("#WXCDFRE")).thenReturn(true);
		
		assertEquals(userJobSeekerService.validationAuthToken("#WXCDFRE"), true);
	}
	
	@Test
	void testAuthenticateUserJobLoginTrueTest() {
		
		UserJobSeekerDTO userJobSeekerDTO = new UserJobSeekerDTO();
		userJobSeekerDTO.setAddress("Pune");
		when(userJobSeekerService.authenticateUserJobLogin(userJobSeekerDTO)).thenReturn(userJobSeekerDTO.getAddress());
		
		assertEquals(userJobSeekerService.authenticateUserJobLogin(userJobSeekerDTO), "Pune");
	}
	
	
	@Test
	void testRegisterUserJobSeekerTrueTest() {
		UserJobSeekerDTO userJobSeekerDTO = new UserJobSeekerDTO();
		userJobSeekerDTO.setAddress("Pune");
		when(userJobSeekerService.registerUserJobSeeker(userJobSeekerDTO)).thenReturn(userJobSeekerDTO);
		
		assertEquals(userJobSeekerService.registerUserJobSeeker(userJobSeekerDTO).getAddress(), "Pune");
	}
	
	
	@Test
	void testGetUsernameFalseTest() {
		
		
		when(userJobSeekerService.getUsername("#WDSRRGF")).thenReturn("Jerry");
		
		assertNotEquals(userJobSeekerService.getUsername("#WDSRRGF"), "Honey");
		
	}
	
	@Test
	void testValidationAuthTokenFalseTest() {
		
		when(userJobSeekerService.validationAuthToken("#WXCDFRE")).thenReturn(true);
		
		assertNotEquals(userJobSeekerService.validationAuthToken("#WXCDFRE"), false);
	}
	
	@Test
	void testAuthenticateUserJobLoginFalseTest() {
		
		UserJobSeekerDTO userJobSeekerDTO = new UserJobSeekerDTO();
		userJobSeekerDTO.setAddress("Pune");
		when(userJobSeekerService.authenticateUserJobLogin(userJobSeekerDTO)).thenReturn(userJobSeekerDTO.getAddress());
		
		assertNotEquals(userJobSeekerService.authenticateUserJobLogin(userJobSeekerDTO), "Punjab");
	}
	
	
	@Test
	void testRegisterUserJobSeekerFalseTest() {
		UserJobSeekerDTO userJobSeekerDTO = new UserJobSeekerDTO();
		userJobSeekerDTO.setAddress("Pune");
		when(userJobSeekerService.registerUserJobSeeker(userJobSeekerDTO)).thenReturn(userJobSeekerDTO);
		
		assertNotEquals(userJobSeekerService.registerUserJobSeeker(userJobSeekerDTO).getAddress(), "Punjab");
	}
	
	

}
