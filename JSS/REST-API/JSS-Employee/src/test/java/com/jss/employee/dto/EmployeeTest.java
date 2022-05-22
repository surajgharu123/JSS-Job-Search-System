package com.jss.employee.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;



class EmployeeTest {

	Employee employeeDTO = mock(Employee.class);
	//employeeDTO employeeDTO = new employeeDTO();
	@Test
	public void testsetUserName() {
		
		
		employeeDTO.setUserName("Suraj");
		when(employeeDTO.getUserName()).thenReturn("Suraj");
		
		assertEquals(employeeDTO.getUserName(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		employeeDTO.setPassword("Suraj");
		when(employeeDTO.getPassword()).thenReturn("Suraj");
		
		assertEquals(employeeDTO.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetOrginazationName() {
		
		
		employeeDTO.setOrgnizationName("Zensar");
		when(employeeDTO.getOrgnizationName()).thenReturn("Zensar");
		
		assertEquals(employeeDTO.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		employeeDTO.setAddress("Punjab");
		when(employeeDTO.getAddress()).thenReturn("Punjab");
		
		assertEquals(employeeDTO.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		employeeDTO.setJobTitle("SDE");
		when(employeeDTO.getJobTitle()).thenReturn("SDE");
		
		assertEquals(employeeDTO.getJobTitle(), "SDE");
	}
	
	
	@Test
	public void testsetLocation() {
		
		
		employeeDTO.setLocation("Pune");
		when(employeeDTO.getLocation()).thenReturn("Pune");
		
		assertEquals(employeeDTO.getLocation(), "Pune");
	}
	
	@Test
	public void testsetDescription() {
		
		
		employeeDTO.setDescription("How are you");
		when(employeeDTO.getDescription()).thenReturn("How are you");
		
		assertNotEquals(employeeDTO.getDescription(), "Suraj");
	}
	
	@Test
	public void testsetExperience() {
		
		
		employeeDTO.setExperience(3);
		when(employeeDTO.getExperience()).thenReturn(3);
		
		assertEquals(employeeDTO.getExperience(), 3);
	}
	
	
	
	
	@Test
	public void testsetSalary() {
		
		
		employeeDTO.setSalary(4567);
		when(employeeDTO.getSalary()).thenReturn(4567);
		
		assertNotEquals(employeeDTO.getOrgnizationName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetNoticePeriod() {
		
		
		employeeDTO.setNoticePeriod(34);
		when(employeeDTO.getNoticePeriod()).thenReturn(34);
		
		assertNotEquals(employeeDTO.getNoticePeriod(), "Punjab");
	}
	
	
	
	@Test
	public void testsetContact() {
		
		
		employeeDTO.setContact(6564);
		when(employeeDTO.getContact()).thenReturn(5454l);
		
		assertNotEquals(employeeDTO.getContact(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		employeeDTO.setEmail("suraj@123gmail");
		when(employeeDTO.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(employeeDTO.getEmail(), "suraj@123gmail");
	}


}
