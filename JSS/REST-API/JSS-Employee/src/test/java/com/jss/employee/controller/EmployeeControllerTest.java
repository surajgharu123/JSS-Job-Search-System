package com.jss.employee.controller;

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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jss.employee.dto.Job;
import com.jss.employee.dto.JobSeeker;
import com.jss.employee.service.EmployeeService;
import com.jss.employee.service.JobSeekerService;
import com.jss.employee.service.JobService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc; // Mocking

	@Autowired
	EmployeeController employeeController; // It will helps to call apis

	@MockBean
	JobSeekerService jobSeekerService; // It will

	@MockBean
	EmployeeService employeeService;

	@MockBean
	JobService jobService;

	@Autowired
	ObjectMapper objectMapper; // It will convert objects

	@Test
	public void testSearchJobseekerByFilterCriteria() throws Exception {
		List<JobSeeker> jobDTOList = new ArrayList<JobSeeker>();
		jobDTOList.add(new JobSeeker());
		jobDTOList.add(new JobSeeker());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#$%SDF");
		when(this.jobSeekerService.filterJobSeekerBySkills("css", "#$%SDF")).thenReturn(jobDTOList);

		MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:5301/jss/employee/search/filtercriteria")
				.headers(httpHeaders).param("skillSet", "css")).andExpect(status().isOk()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("address"), true);

	}

	@Test
	public void testDeleteJobById() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#$%SDF");
		when(this.jobService.deleteJobById(1, "#$%SDF")).thenReturn(true);

		MvcResult mvcResult = this.mockMvc
				.perform(delete("http://localhost:5301/jss/employee/delete/" + 1).headers(httpHeaders))
				.andExpect(status().isOk()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("true"), true);

	}

	@Test
	public void testUpdateJobById() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "#$%SDF");
		when(this.jobService.updateJob(1, "#$%SDF", new Job())).thenReturn(new Job());

		MvcResult mvcResult = this.mockMvc
				.perform(put("http://localhost:5301/jss/employee/update/1").contentType("application/json")
						.content(objectMapper.writeValueAsString(new Job())).headers(httpHeaders))
				.andExpect(status().isOk()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(true, true);

	}

	@Test
	public void testSearchByJobId() throws Exception {
		List<Job> job = new ArrayList<Job>();
		job.add(new Job());
		job.add(new Job());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "D78KL");
		when(this.jobService.searchByJobId(1, "D78KL")).thenReturn(job);

		MvcResult mvcResult = this.mockMvc
				.perform(get("http://localhost:5500/jss/employee/search").headers(httpHeaders).param("jobID", "1"))
				.andExpect(status().isOk()).andReturn();

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(true, response.contains("id"));
	}
}
