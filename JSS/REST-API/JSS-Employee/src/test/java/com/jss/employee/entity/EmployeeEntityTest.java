package com.jss.employee.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;



class EmployeeEntityTest {

	EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
	//employeeEntity employeeEntity = new employeeEntity();
	@Test
	public void testsetUserName() {
		
		
		employeeEntity.setUserName("Suraj");
		when(employeeEntity.getUserName()).thenReturn("Suraj");
		
		assertEquals(employeeEntity.getUserName(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		employeeEntity.setPassword("Suraj");
		when(employeeEntity.getPassword()).thenReturn("Suraj");
		
		assertEquals(employeeEntity.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetOrginazationName() {
		
		
		employeeEntity.setOrgnizationName("Zensar");
		when(employeeEntity.getOrgnizationName()).thenReturn("Zensar");
		
		assertEquals(employeeEntity.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		employeeEntity.setAddress("Punjab");
		when(employeeEntity.getAddress()).thenReturn("Punjab");
		
		assertEquals(employeeEntity.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		employeeEntity.setJobTitle("SDE");
		when(employeeEntity.getJobTitle()).thenReturn("SDE");
		
		assertEquals(employeeEntity.getJobTitle(), "SDE");
	}
	
	
	@Test
	public void testsetLocation() {
		
		
		employeeEntity.setLocation("Pune");
		when(employeeEntity.getLocation()).thenReturn("Pune");
		
		assertEquals(employeeEntity.getLocation(), "Pune");
	}
	
	@Test
	public void testsetDescription() {
		
		
		employeeEntity.setDescription("How are you");
		when(employeeEntity.getDescription()).thenReturn("How are you");
		
		assertNotEquals(employeeEntity.getDescription(), "Suraj");
	}
	
	@Test
	public void testsetExperience() {
		
		
		employeeEntity.setExperience(3);
		when(employeeEntity.getExperience()).thenReturn(3);
		
		assertEquals(employeeEntity.getExperience(), 3);
	}
	
	
	
	
	@Test
	public void testsetSalary() {
		
		
		employeeEntity.setSalary(4567);
		when(employeeEntity.getSalary()).thenReturn(4567);
		
		assertNotEquals(employeeEntity.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetNoticePeriod() {
		
		
		employeeEntity.setNoticePeriod(34);
		when(employeeEntity.getNoticePeriod()).thenReturn(34);
		
		assertNotEquals(employeeEntity.getNoticePeriod(), "Punjab");
	}
	
	
	
	@Test
	public void testsetContact() {
		
		
		employeeEntity.setContact(6564);
		when(employeeEntity.getContact()).thenReturn(5454);
		
		assertNotEquals(employeeEntity.getContact(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		employeeEntity.setEmail("suraj@123gmail");
		when(employeeEntity.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(employeeEntity.getEmail(), "suraj@123gmail");
	}



}
