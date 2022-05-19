package com.jss.jobseeker.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;



class JobEntityTest {

	JobEntity jobEntity = mock(JobEntity.class);
	//jobEntity jobEntity = new jobEntity();
	@Test
	public void testsetJobTitle() {
		
		
		jobEntity.setJobTitle("SDE");
		when(jobEntity.getJobTitle()).thenReturn("SDE");
		
		assertEquals(jobEntity.getJobTitle(), "SDE");
	}
	
	
	
	
	@Test
	public void testsetSkillset() {
		
		
		jobEntity.setSkills("CSS");
		when(jobEntity.getSkills()).thenReturn("CSS");
		
		assertNotEquals(jobEntity.getSkills(), "Zensar");
	}
	
	
	
	@Test
	public void testsetAddress() {
		
		
		jobEntity.setCompanyName("Zensar");
		when(jobEntity.getCompanyName()).thenReturn("Zensar");
		
		assertEquals(jobEntity.getCompanyName(), "Zensar");
	}
	
	
	
	@Test
	public void testsetDescription() {
		
		
		jobEntity.setDescription("This is Service Based Company");
		when(jobEntity.getDescription()).thenReturn("This is Service Based Company");
		
		assertEquals(jobEntity.getDescription(), "This is Service Based Company");
	}
	
	
	
	@Test
	public void testsetExperience() {
		
		
		jobEntity.setExperience(2);
		when(jobEntity.getExperience()).thenReturn(2);
		
		assertEquals(jobEntity.getExperience(), 2);
	}
	
	
	
	
	
	@Test
	public void testsetLocation() {
		
		
		jobEntity.setLocation("Pune");
		when(jobEntity.getLocation()).thenReturn("Punjab");
		
		assertNotEquals(jobEntity.getLocation(), "Pune");
	}
	
	
	@Test
	public void testsetSalary() {
		
		
		jobEntity.setSalary(56344.87);
		when(jobEntity.getSalary()).thenReturn(56344.87);
		
		assertEquals(jobEntity.getSalary(), 56344.87);
	}
	
	
	@Test
	public void testsetNoticePeriod() {
		
		
		jobEntity.setNoticePeriod(34);
		when(jobEntity.getNoticePeriod()).thenReturn(34);
		
		assertEquals(jobEntity.getNoticePeriod(), 34);
	}


}
