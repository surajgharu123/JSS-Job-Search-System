package com.jss.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.jss.employee.service.EmployeeService;
import com.jss.employee.service.JobSeekerService;
import com.jss.employee.service.JobService;
//import com.jss.employee.service.JobService;
import com.jss.employee.dto.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/jss/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	JobService jobService;
	
	
	@GetMapping(value = "/search/filtercriteria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of JobSeeker by FilterCriteria", notes = "This Rest API will return List of JobSeeker by Filter Criteria")
	public ResponseEntity<List<JobSeeker>> searchByFilterCriteria(
			@RequestParam(name = "skillSet", required = false) String skillSet)
			 {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.filterJobSeekerBySkills(skillSet), HttpStatus.OK);
	}
	
//	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiOperation(value = "Getting a List of Jobs by Job Id", notes = "This Rest API will return List of Jobs by Job Id")
//	public ResponseEntity<List<Job>> searchByJobId(@RequestParam(name = "jobID", required = false) Integer id,
//			@RequestHeader("Authorization") String authToken){
//		List<Job> job1=this.jobService.searchByJobId(id,authToken);
//		return new ResponseEntity<List<Job>>(job1, HttpStatus.OK);
//	}
	
//    @PutMapping(value = "/update/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
//					MediaType.APPLICATION_XML_VALUE })
//    @ApiOperation(value = "Updating Job by Job Id", notes = "This Rest API will update Job by Job Id")
    
    
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of Jobs by Job Id", notes = "This Rest API will return List of Jobs by Job Id")
	public ResponseEntity<List<Job>> searchByJobId(
			@RequestParam(name = "jobID", required = false) Integer id)
			 {
		return new ResponseEntity<List<Job>>(jobService.searchByJobId(id), HttpStatus.OK);

	}
	
	
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Deleting a Job by Job Id", notes = "This Rest API will delete Job by Job Id")
	public ResponseEntity<Boolean> deleteJobById(@ApiParam(value="JobID", name="Deleting Job") @PathVariable("id") int id, @RequestHeader("Authorization") String authToken ) {
		return new ResponseEntity<Boolean> (jobService.deleteJobById(id,authToken),HttpStatus.OK);
	}
	
    @PutMapping(value = "/update/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Updating Job by Job Id", notes = "This Rest API will update Job by Job Id")
    public ResponseEntity<Job> updateJob(@RequestBody Job job, @ApiParam(value="JobID", name="For Updating a Job")@PathVariable("id") int id, @RequestHeader("Authorization") String authToken) {
		return new ResponseEntity<Job>(jobService.updateJob( id,authToken, job),HttpStatus.OK);

	}

}
