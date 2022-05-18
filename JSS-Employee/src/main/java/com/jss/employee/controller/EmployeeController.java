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
import com.jss.employee.dto.*;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/Employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	
	@GetMapping(value = "/search/filtercriteria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of JobSeeker by FilterCriteria", notes = "This Rest API will return List of JobSeeker by Filter Criteria")
	public ResponseEntity<List<JobSeeker>> searchJobSeekerByFilterCriteria(
			@RequestParam(name = "searchText", required = false) String skillSet)
			 {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.filterJobSeeker(skillSet), HttpStatus.OK);
	}
	
	

}
