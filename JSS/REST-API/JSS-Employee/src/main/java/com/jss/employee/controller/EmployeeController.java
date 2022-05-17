package com.jss.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.jss.employee.service.JobSeekerService;
import com.jss.employee.service.JobService;
import com.jss.employee.dto.*;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("jss/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	JobService jobService;
	
	
	@GetMapping(value = "/search/filtercriteria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of JobSeeker by FilterCriteria", notes = "This Rest API will return List of JobSeeker by Filter Criteria")
	public ResponseEntity<List<JobSeeker>> searchAdvertisesByFilterCriteria(
			@RequestParam(name = "searchText", required = false) String skillSet)
			 {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.filterAdvertise(skillSet), HttpStatus.OK);
	}
	
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of Jobs by Job Id", notes = "This Rest API will return List of Jobs by Job Id")
	public ResponseEntity<List<Job>> searchByJobId(
			@RequestParam(name = "searchText", required = false) Integer id)
			 {
		return new ResponseEntity<List<Job>>(jobService.searchByJobId(id), HttpStatus.OK);
	}

}
