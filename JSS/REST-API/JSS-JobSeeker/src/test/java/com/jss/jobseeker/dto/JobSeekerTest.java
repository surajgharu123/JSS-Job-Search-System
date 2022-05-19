package com.jss.jobseeker.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


class JobSeekerTest {

	JobSeekerDTO jobSeekerDTO = mock(JobSeekerDTO.class);
	//jobSeekerDTO jobSeekerDTO = new jobSeekerDTO();
	@Test
	public void testsetUserName() {
		
		
		jobSeekerDTO.setUsername("Suraj");
		when(jobSeekerDTO.getUsername()).thenReturn("Suraj");
		
		assertEquals(jobSeekerDTO.getUsername(), "Suraj");
	}
	
	@Test
	public void testsetPassword() {
		
		
		jobSeekerDTO.setPassword("Suraj");
		when(jobSeekerDTO.getPassword()).thenReturn("Suraj");
		
		assertEquals(jobSeekerDTO.getPassword(), "Suraj");
	}
	
	
	
	
	@Test
	public void testsetSkillset() {
		
		
		jobSeekerDTO.setSkillset("CSS");
		when(jobSeekerDTO.getSkillset()).thenReturn("CSS");
		
		assertNotEquals(jobSeekerDTO.getSkillset(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		jobSeekerDTO.setAddress("Punjab");
		when(jobSeekerDTO.getAddress()).thenReturn("Punjab");
		
		assertEquals(jobSeekerDTO.getAddress(), "Punjab");
	}
	
	
	
	@Test
	public void testsetJobTitle() {
		
		
		jobSeekerDTO.setJobID(1);
		when(jobSeekerDTO.getJobID()).thenReturn(1);
		
		assertEquals(jobSeekerDTO.getJobID(), 1);
	}
	
	
	
	@Test
	public void testsetName() {
		
		
		jobSeekerDTO.setName("Jerry");
		when(jobSeekerDTO.getName()).thenReturn("Jerry");
		
		assertNotEquals(jobSeekerDTO.getName(), "Suraj");
	}
	
	
	
	
	
	@Test
	public void testsetContact() {
		
		
		jobSeekerDTO.setContactNo(6564);
		when(jobSeekerDTO.getContactNo()).thenReturn(5454l);
		
		assertNotEquals(jobSeekerDTO.getContactNo(), "SDE");
	}
	
	
	@Test
	public void testsetEmail() {
		
		
		jobSeekerDTO.setEmail("suraj@123gmail");
		when(jobSeekerDTO.getEmail()).thenReturn("suraj@123gmail");
		
		assertEquals(jobSeekerDTO.getEmail(), "suraj@123gmail");
	}

}
