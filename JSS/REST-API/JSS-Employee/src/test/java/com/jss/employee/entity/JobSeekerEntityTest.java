package com.jss.employee.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.jss.employee.dto.JobSeeker;

class JobSeekerEntityTest {

	JobSeekerEntity jobSeekerEntity = mock(JobSeekerEntity.class);

	// jobSeekerEntity jobSeekerEntity = new jobSeekerEntity();
	@Test
	public void testsetUserName() {

		jobSeekerEntity.setUsername("Suraj");
		when(jobSeekerEntity.getUsername()).thenReturn("Suraj");

		assertEquals(jobSeekerEntity.getUsername(), "Suraj");
	}

	@Test
	public void testsetPassword() {

		jobSeekerEntity.setPassword("Suraj");
		when(jobSeekerEntity.getPassword()).thenReturn("Suraj");

		assertEquals(jobSeekerEntity.getPassword(), "Suraj");
	}

	@Test
	public void testsetSkillset() {

		jobSeekerEntity.setSkillset("CSS");
		when(jobSeekerEntity.getSkillset()).thenReturn("CSS");

		assertNotEquals(jobSeekerEntity.getSkillset(), "Zensar");
	}

	@Test
	public void testsetAddress() {

		jobSeekerEntity.setAddress("Punjab");
		when(jobSeekerEntity.getAddress()).thenReturn("Punjab");

		assertEquals(jobSeekerEntity.getAddress(), "Punjab");
	}

	@Test
	public void testsetJobTitle() {

		jobSeekerEntity.setJobID(1);
		when(jobSeekerEntity.getJobID()).thenReturn(1);

		assertEquals(jobSeekerEntity.getJobID(), 1);
	}

	@Test
	public void testsetName() {

		jobSeekerEntity.setName("Jerry");
		when(jobSeekerEntity.getName()).thenReturn("Jerry");

		assertNotEquals(jobSeekerEntity.getName(), "Suraj");
	}

	@Test
	public void testsetContact() {

		jobSeekerEntity.setContactNo(6564);
		when(jobSeekerEntity.getContactNo()).thenReturn(5454l);

		assertNotEquals(jobSeekerEntity.getContactNo(), "SDE");
	}

	@Test
	public void testsetEmail() {

		jobSeekerEntity.setEmail("suraj@123gmail");
		when(jobSeekerEntity.getEmail()).thenReturn("suraj@123gmail");

		assertEquals(jobSeekerEntity.getEmail(), "suraj@123gmail");
	}
}
