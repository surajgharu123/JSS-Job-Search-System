package com.jss.jobseeker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.service.JobSeekerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/jss/jobseeker")
@CrossOrigin("*")
public class JobSeekerController {

	@Autowired
	JobSeekerService jobSeekerService;

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	@ApiOperation(value = "Searching A Job By Filtering Criteria", notes = "This Rest API helps to Search a Job by Company Name,"
			+ "Skills & Designation")
	public ResponseEntity<List<JobDTO>> SearchByFilterCriteria(
			@RequestParam(name = "company", required = false) String companyName,
			@RequestParam(name = "skills", required = false) String skills,
			@RequestParam(name = "designation", required = false) String jobTitle) {
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.SearchByFilterCriteria(companyName, skills, jobTitle),
				HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Get All Jobs Data", notes = "This Rest API helps to Get All Data From")
	public ResponseEntity<List<JobDTO>> getAllRecords() {
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.getAllRecords(), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Post a Job", notes = "This Rest API helps to Post a Job")
	public ResponseEntity<JobDTO> addrecords(@RequestBody JobDTO jobSeekerDTO, @RequestHeader("Authorization") String authToken) {
		return new ResponseEntity<JobDTO>(jobSeekerService.createAJob(jobSeekerDTO, authToken), HttpStatus.OK);
	}

	@GetMapping(value = "/searchLocation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Search by Location", notes = "This Rest API helps to Get Job Details by Location")
	public ResponseEntity<List<JobDTO>> searchByLocation(@RequestParam(name = "location") String location) {
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.searchByLocation(location), HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Get Specific Job detials", notes = "This Rest API helps to Get Specific Job Details")
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<JobDTO> getJobByID(@ApiParam(value = "Job", name = "Id") @PathVariable("id") int id,
	@RequestHeader("Authorization") String authToken) {
	return new ResponseEntity<JobDTO>(jobSeekerService.getJobByID(id,authToken), HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "For Applying a new Job", notes = "This Rest API helps to apply for a job")
	@PostMapping(value = "/apply/job", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> applyForJob(@RequestBody JobDTO jobDTO, @RequestHeader("Authorization") String authToken) {
		return new ResponseEntity<Boolean>(jobSeekerService.applyForJob(jobDTO,authToken), HttpStatus.ACCEPTED);
	}
	
	
	
	

}
