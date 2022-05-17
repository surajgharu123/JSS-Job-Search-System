package com.jss.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jss.user.dto.UserJobDTO;
import com.jss.user.service.UserJobService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jss/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserJobService userJobServices;
	

	@PostMapping(value="job/register",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Add new JobSeeker",notes = "This Rest API is  Adding a new JobSeeker")
	public ResponseEntity<UserJobDTO>  registerUserJobSeeker(@RequestBody UserJobDTO userJobDTO){
		UserJobDTO userJobDto=this.userJobServices.registerUserJobSeeker(userJobDTO);
		return new ResponseEntity<UserJobDTO>(userJobDto,HttpStatus.CREATED) ;
	}
	@PostMapping(value="job/authenticate",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Verify authentication",notes = "This Rest API verifies login authenticaion")
	public ResponseEntity<String>  authenticateUserJobLogin(@RequestBody UserJobDTO userJobDTO) {
		String userJobDto=this.userJobServices.authenticateUserJobLogin(userJobDTO);
		return new ResponseEntity<String>(userJobDto,HttpStatus.OK);
	}
}
