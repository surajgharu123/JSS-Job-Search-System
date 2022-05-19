package com.jss.employee.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class JobTest {

	Job jobDTO = mock(Job.class);
	
	@Test
	public void testsetJobTitle() {

		jobDTO.setJobTitle("SDE");
		when(jobDTO.getJobTitle()).thenReturn("SDE");

		assertEquals(jobDTO.getJobTitle(), "SDE");
	}

	@Test
	public void testsetSkillset() {

		jobDTO.setSkills("CSS");
		when(jobDTO.getSkills()).thenReturn("CSS");

		assertNotEquals(jobDTO.getSkills(), "Zensar");
	}

	@Test
	public void testsetAddress() {

		jobDTO.setCompanyName("Zensar");
		when(jobDTO.getCompanyName()).thenReturn("Zensar");

		assertEquals(jobDTO.getCompanyName(), "Zensar");
	}

	@Test
	public void testsetDescription() {

		jobDTO.setDescription("This is Service Based Company");
		when(jobDTO.getDescription()).thenReturn("This is Service Based Company");

		assertEquals(jobDTO.getDescription(), "This is Service Based Company");
	}

	@Test
	public void testsetExperience() {

		jobDTO.setExperience(2);
		when(jobDTO.getExperience()).thenReturn(2);

		assertEquals(jobDTO.getExperience(), 2);
	}

	@Test
	public void testsetLocation() {

		jobDTO.setLocation("Pune");
		when(jobDTO.getLocation()).thenReturn("Punjab");

		assertNotEquals(jobDTO.getLocation(), "Pune");
	}

	@Test
	public void testsetSalary() {

		jobDTO.setSalary(56344.87);
		when(jobDTO.getSalary()).thenReturn(56344.87);

		assertEquals(jobDTO.getSalary(), 56344.87);
	}

	@Test
	public void testsetNoticePeriod() {

		jobDTO.setNoticePeriod(34);
		when(jobDTO.getNoticePeriod()).thenReturn(34);

		assertEquals(jobDTO.getNoticePeriod(), 34);
	}

}
