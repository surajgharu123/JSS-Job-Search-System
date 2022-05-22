package com.jss.user.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	UserEmployeeDTO userEmployeeDTO = mock(UserEmployeeDTO.class);
	//UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO();
	@Test
	public void testsetUserName() {
		
		
		userEmployeeDTO.setUserName("Suraj");
		when(userEmployeeDTO.getUserName()).thenReturn("Suraj");
		
		assertEquals(userEmployeeDTO.getUserName(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		userEmployeeDTO.setPassword("Suraj");
		when(userEmployeeDTO.getPassword()).thenReturn("Suraj");
		
		assertEquals(userEmployeeDTO.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetOrginazationName() {
		
		
		userEmployeeDTO.setOrgnizationName("Zensar");
		when(userEmployeeDTO.getOrgnizationName()).thenReturn("Zensar");
		
		assertEquals(userEmployeeDTO.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		userEmployeeDTO.setAddress("Punjab");
		when(userEmployeeDTO.getAddress()).thenReturn("Punjab");
		
		assertEquals(userEmployeeDTO.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		userEmployeeDTO.setJobTitle("SDE");
		when(userEmployeeDTO.getJobTitle()).thenReturn("SDE");
		
		assertEquals(userEmployeeDTO.getJobTitle(), "SDE");
	}
	
	
	@Test
	public void testsetLocation() {
		
		
		userEmployeeDTO.setLocation("Pune");
		when(userEmployeeDTO.getLocation()).thenReturn("Pune");
		
		assertEquals(userEmployeeDTO.getLocation(), "Pune");
	}
	
	@Test
	public void testsetDescription() {
		
		
		userEmployeeDTO.setDescription("How are you");
		when(userEmployeeDTO.getDescription()).thenReturn("How are you");
		
		assertNotEquals(userEmployeeDTO.getDescription(), "Suraj");
	}
	
	@Test
	public void testsetExperience() {
		
		
		userEmployeeDTO.setExperience(3);
		when(userEmployeeDTO.getExperience()).thenReturn(3);
		
		assertEquals(userEmployeeDTO.getExperience(), 3);
	}
	
	
	
	
	@Test
	public void testsetSalary() {
		
		
		userEmployeeDTO.setSalary(4567);
		when(userEmployeeDTO.getSalary()).thenReturn(4567);
		
		assertNotEquals(userEmployeeDTO.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetNoticePeriod() {
		
		
		userEmployeeDTO.setNoticePeriod(34);
		when(userEmployeeDTO.getNoticePeriod()).thenReturn(34);
		
		assertNotEquals(userEmployeeDTO.getNoticePeriod(), "Punjab");
	}
	
	
	
	@Test
	public void testsetContact() {
		
		
		userEmployeeDTO.setContact(6564);
		when(userEmployeeDTO.getContact()).thenReturn(5454l);
		
		assertNotEquals(userEmployeeDTO.getContact(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		userEmployeeDTO.setEmail("suraj@123gmail");
		when(userEmployeeDTO.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(userEmployeeDTO.getEmail(), "suraj@123gmail");
	}

}
