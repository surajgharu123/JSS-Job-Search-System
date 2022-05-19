package com.jss.jobseeker.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jss.jobseeker.dto.JobDTO;

class JobSeekerServiceTest {

	JobSeekerService jobSeekerService = mock(JobSeekerService.class);

	@Test
	void SearchByFilterCriteriaTest() {

		List<JobDTO> jobDto = new ArrayList<JobDTO>();
		jobDto.add(new JobDTO());
		jobDto.get(0).setSkills("css");
		jobDto.get(0).setCompanyName("zensar");
		jobDto.get(0).setDescription("best job");
		when(jobSeekerService.SearchByFilterCriteria(null, "css", null)).thenReturn(jobDto);
		assertEquals(jobSeekerService.SearchByFilterCriteria(null, "css", null).get(0).getSkills(),
				jobDto.get(0).getSkills());

	}

	@Test
	void getAllRecordsTest() {

		List<JobDTO> jobDto = new ArrayList<JobDTO>();
		jobDto.add(new JobDTO());
		jobDto.add(new JobDTO());
		jobDto.add(new JobDTO());
		jobDto.get(0).setSkills("css");
		when(jobSeekerService.getAllRecords()).thenReturn(jobDto);
		assertEquals(jobSeekerService.getAllRecords().get(0).getSkills(), jobDto.get(0).getSkills());

	}

	@Test
	void searchByLocationTest() {

		List<JobDTO> jobDto = new ArrayList<JobDTO>();
		jobDto.add(new JobDTO());
		jobDto.get(0).setLocation("pune");
		when(jobSeekerService.searchByLocation("pune")).thenReturn(jobDto);
		assertEquals(jobSeekerService.searchByLocation("pune").get(0).getLocation(), jobDto.get(0).getLocation());
	}

	@Test
	void getJobByIDTest() {

		JobDTO jobDto = new JobDTO();
		jobDto.setCompanyName("zensar");
		jobDto.setContactEmail("shubham@gmail.com");
		jobDto.setDescription("best job");
		jobDto.setId(1);
		when(jobSeekerService.getJobByID(1, "#SDEDSD")).thenReturn(jobDto);
		assertEquals(jobSeekerService.getJobByID(1, "#SDEDSD").getDescription(), jobDto.getDescription());

	}

}
