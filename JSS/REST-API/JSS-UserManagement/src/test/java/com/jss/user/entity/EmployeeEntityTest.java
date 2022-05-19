package com.jss.user.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import com.jss.user.dto.UserJobSeekerDTO;

class EmployeeEntityTest {

	UserEmployeeEntity userEmployeeEntity = mock(UserEmployeeEntity.class);
	//userEmployeeEntity userEmployeeEntity = new userEmployeeEntity();
	@Test
	public void testsetUserName() {
		
		
		userEmployeeEntity.setUserName("Suraj");
		when(userEmployeeEntity.getUserName()).thenReturn("Suraj");
		
		assertEquals(userEmployeeEntity.getUserName(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		userEmployeeEntity.setPassword("Suraj");
		when(userEmployeeEntity.getPassword()).thenReturn("Suraj");
		
		assertEquals(userEmployeeEntity.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetOrginazationName() {
		
		
		userEmployeeEntity.setOrgnizationName("Zensar");
		when(userEmployeeEntity.getOrgnizationName()).thenReturn("Zensar");
		
		assertEquals(userEmployeeEntity.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		userEmployeeEntity.setAddress("Punjab");
		when(userEmployeeEntity.getAddress()).thenReturn("Punjab");
		
		assertEquals(userEmployeeEntity.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		userEmployeeEntity.setJobTitle("SDE");
		when(userEmployeeEntity.getJobTitle()).thenReturn("SDE");
		
		assertEquals(userEmployeeEntity.getJobTitle(), "SDE");
	}
	
	
	@Test
	public void testsetLocation() {
		
		
		userEmployeeEntity.setLocation("Pune");
		when(userEmployeeEntity.getLocation()).thenReturn("Pune");
		
		assertEquals(userEmployeeEntity.getLocation(), "Pune");
	}
	
	@Test
	public void testsetDescription() {
		
		
		userEmployeeEntity.setDescription("How are you");
		when(userEmployeeEntity.getDescription()).thenReturn("How are you");
		
		assertNotEquals(userEmployeeEntity.getDescription(), "Suraj");
	}
	
	@Test
	public void testsetExperience() {
		
		
		userEmployeeEntity.setExperience(3);
		when(userEmployeeEntity.getExperience()).thenReturn(3);
		
		assertEquals(userEmployeeEntity.getExperience(), 3);
	}
	
	
	
	
	@Test
	public void testsetSalary() {
		
		
		userEmployeeEntity.setSalary(4567);
		when(userEmployeeEntity.getSalary()).thenReturn(4567);
		
		assertNotEquals(userEmployeeEntity.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetNoticePeriod() {
		
		
		userEmployeeEntity.setNoticePeriod(34);
		when(userEmployeeEntity.getNoticePeriod()).thenReturn(34);
		
		assertNotEquals(userEmployeeEntity.getNoticePeriod(), "Punjab");
	}
	
	
	
	@Test
	public void testsetContact() {
		
		
		userEmployeeEntity.setContact(6564);
		when(userEmployeeEntity.getContact()).thenReturn(5454);
		
		assertNotEquals(userEmployeeEntity.getContact(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		userEmployeeEntity.setEmail("suraj@123gmail");
		when(userEmployeeEntity.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(userEmployeeEntity.getEmail(), "suraj@123gmail");
	}

}
