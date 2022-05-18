package com.jss.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jss.user.dto.UserEmployeeDTO;
import com.jss.user.dto.UserJobSeekerDTO;
import com.jss.user.service.UserJobSeekerService;
import com.jss.user.service.UserEmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jss/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserJobSeekerService userJobServices;
	
	@Autowired
	UserEmployeeService userService;
	

	@PostMapping(value="/job/register",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Add new JobSeeker",notes = "This Rest API is  Adding a new JobSeeker")
	public ResponseEntity<UserJobSeekerDTO>  registerUserJobSeeker(@RequestBody UserJobSeekerDTO userJobDTO){
		UserJobSeekerDTO userJobDto=this.userJobServices.registerUserJobSeeker(userJobDTO);
		return new ResponseEntity<UserJobSeekerDTO>(userJobDto,HttpStatus.CREATED) ;
	}
	@PostMapping(value="/job/authenticate",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Verify authentication",notes = "This Rest API verifies login authenticaion")
	public ResponseEntity<String>  authenticateUserJobLogin(@RequestBody UserJobSeekerDTO userJobDTO) {
		String userJobDto=this.userJobServices.authenticateUserJobLogin(userJobDTO);
		return new ResponseEntity<String>(userJobDto,HttpStatus.OK);
	}
	@PostMapping(value = "/employee/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authenticateEmployee(@RequestBody UserEmployeeDTO login){
		//return new ResponseEntity<String>("RP432",HttpStatus.OK);
        return userService.authenticateEmployee(login);

		
	}
	//Register User
	
	@PostMapping(value = "/employee/register",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserEmployeeDTO getUserRegistration(@RequestBody UserEmployeeDTO login){
	//	login.setId(1001);
		//return new ResponseEntity<UserDTO>(login, HttpStatus.OK);
        return userService.getUserRegistration(login);

		
	}
	
	@PostMapping(value="/employee/validate/auth-token",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	//@ApiOperation(value = "Verify authentication",notes = "This Rest API verifies login authenticaion")
	public ResponseEntity<Boolean> validateEmplyoeeAuthToken(@RequestHeader("Authorization") String authToken) {
	return new ResponseEntity<Boolean>(this.userService.validationAuthToken(authToken),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Check Validation of Auth token For Jobseeker", notes = "This Rest API helps to Check Validaty")
	@PostMapping(value = "/auth-token/validation/jobseeker", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Boolean> validatingJobSeekerAuthToken(@RequestHeader("Authorization") String authToken) {
	return new ResponseEntity<Boolean>(userJobServices.validationAuthToken(authToken), HttpStatus.ACCEPTED);
	}
	
//	//Create a Job
//	@PostMapping(value = "/employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//	public UserEmployeeDTO createEmployee(@RequestHeader("auth-token") String authToken,@RequestBody UserEmployeeDTO user){
//		UserEmployeeDTO userDTO=new UserEmployeeDTO();
////		if(authToken.equalsIgnoreCase("1000")) {
////			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
////		}
////		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
//        return userService.createEmployee(authToken);
//
//	}

}
