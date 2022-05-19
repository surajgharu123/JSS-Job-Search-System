package com.jss.jobseeker.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.service.JobSeekerService;

@WebMvcTest(JobSeekerController.class)
class JobSeekerControllerTest {

	@Autowired
	MockMvc mockMvc; // Mocking

	@Autowired
	JobSeekerController jobSeekerController; // It will helps to call apis

	@MockBean
	JobSeekerService jobSeekerService; // It will

	@Autowired
	ObjectMapper objectMapper; // It will convert objects

	@Test
	public void testSearchJobByFilterCriteria() throws Exception {
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		jobDTOList.add(new JobDTO());
		jobDTOList.add(new JobDTO());
		System.out.println(jobDTOList);
		when(this.jobSeekerService.SearchByFilterCriteria("zensar", null, null)).thenReturn(jobDTOList);

		MvcResult mvcResult = this.mockMvc
				.perform(get("http://localhost:5302/jss/jobseeker/search").param("company", "zensar"))
				.andExpect(status().isOk()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("jobTitle"), true);
	}

	@Test
	public void testGetAllRecords() throws Exception {
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		jobDTOList.add(new JobDTO());
		jobDTOList.add(new JobDTO());
		when(this.jobSeekerService.getAllRecords()).thenReturn(jobDTOList);

		MvcResult mvcResult = this.mockMvc
				.perform(get("http://localhost:5302/jss/jobseeker/"))
				.andExpect(status().isAccepted()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("jobTitle"), true);

	}

	@Test
	public void testSearchJobByJobID() throws Exception {
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		jobDTOList.add(new JobDTO());
		jobDTOList.add(new JobDTO());
		when(this.jobSeekerService.searchByLocation("Pune")).thenReturn(jobDTOList);

		MvcResult mvcResult = this.mockMvc
				.perform(get("http://localhost:5302/jss/jobseeker/searchLocation").param("location", "Pune"))
				.andExpect(status().isAccepted()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("jobTitle"), true);
	}

	@Test
	public void testSearchJobByLocation() throws Exception {

		when(this.jobSeekerService.getJobByID(1,"#ERST")).thenReturn(new JobDTO());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#ERST");
		
		MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:5302/jss/jobseeker/" + 1)
				.headers(httpHeaders))
				.andExpect(status().isAccepted()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("jobTitle"), true);
	}

	@Test
	public void testApplyForSpecificJob() throws Exception {

		JobDTO jobDto = new JobDTO();
		jobDto.setCompanyName("Zensar");
		jobDto.setJobTitle("Junior D");
		when(this.jobSeekerService.applyForJob(jobDto, "#SDER")).thenReturn(true);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#SDER");

		MvcResult mvcResult = this.mockMvc
				.perform(post("http://localhost:5302/jss/jobseeker/apply/job").contentType("application/json")
						.content(objectMapper.writeValueAsString(jobDto)).headers(httpHeaders))
				.andExpect(status().isAccepted()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("true"), true);
	}
	
	@Test
	public void testAddJob() throws Exception {
		JobDTO jobDto = new JobDTO();
		jobDto.setJobTitle("Zensar");
		when(this.jobSeekerService.createAJob(jobDto, "#SDER")).thenReturn(jobDto);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#SDER");
		MvcResult mvcResult = this.mockMvc
				.perform(post("http://localhost:5302/jss/jobseeker/")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(jobDto))
						.headers(httpHeaders))
				.andExpect(status().isOk()).andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("jobTitle"), true);

		
		
	}

}
