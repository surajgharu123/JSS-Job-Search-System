package com.jss.employee.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.jss.employee.dto.Job;

class JobServiceTest {

	JobService jobService = mock(JobService.class);
	
	@Test
	public void testDeleteById() {
		
		Job jobDTO = new Job();
		jobDTO.setId(1);
		when(jobService.deleteJobById(1, "#SSEWSFE")).thenReturn(true);
		
		assertEquals(jobService.deleteJobById(1, "#SSEWSFE"), true);
		
	}

}
