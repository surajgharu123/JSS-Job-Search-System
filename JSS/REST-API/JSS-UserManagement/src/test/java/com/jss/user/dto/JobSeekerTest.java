package com.jss.user.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class JobSeekerTest {
	UserJobSeekerDTO userJobseekerDTO = mock(UserJobSeekerDTO.class);
	//userJobseekerDTO userJobseekerDTO = new userJobseekerDTO();
	@Test
	public void testsetUserName() {
		
		
		userJobseekerDTO.setUsername("Suraj");
		when(userJobseekerDTO.getUsername()).thenReturn("Suraj");
		
		assertEquals(userJobseekerDTO.getUsername(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		userJobseekerDTO.setPassword("Suraj");
		when(userJobseekerDTO.getPassword()).thenReturn("Suraj");
		
		assertEquals(userJobseekerDTO.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetSkillset() {
		
		
		userJobseekerDTO.setSkillset("CSS");
		when(userJobseekerDTO.getSkillset()).thenReturn("CSS");
		
		assertNotEquals(userJobseekerDTO.getSkillset(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		userJobseekerDTO.setAddress("Punjab");
		when(userJobseekerDTO.getAddress()).thenReturn("Punjab");
		
		assertEquals(userJobseekerDTO.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		userJobseekerDTO.setJobID(1);
		when(userJobseekerDTO.getJobID()).thenReturn(1);
		
		assertEquals(userJobseekerDTO.getJobID(), 1);
	}
	
	
	
	@Test
	public void testsetName() {
		
		
		userJobseekerDTO.setName("Jerry");
		when(userJobseekerDTO.getName()).thenReturn("Jerry");
		
		assertNotEquals(userJobseekerDTO.getName(), "Suraj");
	}
	
	
	
	
	
	@Test
	public void testsetContact() {
		
		
		userJobseekerDTO.setContactNo(6564);
		when(userJobseekerDTO.getContactNo()).thenReturn(5454l);
		
		assertNotEquals(userJobseekerDTO.getContactNo(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		userJobseekerDTO.setEmail("suraj@123gmail");
		when(userJobseekerDTO.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(userJobseekerDTO.getEmail(), "suraj@123gmail");
	}

}
