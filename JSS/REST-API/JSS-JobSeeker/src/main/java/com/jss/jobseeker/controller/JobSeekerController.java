package com.jss.jobseeker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jss.jobseeker.dto.JobDTO;
import com.jss.jobseeker.service.JobSeekerService;

@RestController
@RequestMapping("/jss/jobseeker/")
@CrossOrigin("*")
public class JobSeekerController {
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	@GetMapping(value="/search",
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<JobDTO>> SearchByFilterCriteria(
			@RequestParam(name="company", required = false) String companyName,
			@RequestParam(name="skills", required =false) String skills,
			@RequestParam(name="designation", required = false) String jobTitle){
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.SearchByFilterCriteria(companyName, skills, jobTitle),
				HttpStatus.OK);
	}
	
	@GetMapping(value="/",
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<JobDTO>> getAllRecords() {
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.getAllRecords()
				,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/", consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<JobDTO> addrecords(@RequestBody JobDTO jobSeekerDTO) {
		return new ResponseEntity<JobDTO>(jobSeekerService.addrecords(jobSeekerDTO),HttpStatus.OK);
	}
	
	@GetMapping(value="/searchLocation",
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<JobDTO>> searchByLocation(@RequestParam(name = "location") String location) {
		return new ResponseEntity<List<JobDTO>>(jobSeekerService.searchByLocation(location)
				,HttpStatus.ACCEPTED);
	}

}
