package com.jss.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jss.user.dto.UserDTO;
import com.jss.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jss")

public class UserController {
	
	@Autowired
	UserService userService;
	//Login End Point
	@PostMapping(value = "/employee/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String authenticateEmployee(@RequestBody UserDTO login){
		//return new ResponseEntity<String>("RP432",HttpStatus.OK);
        return userService.authenticateEmployee(login);

		
	}
	//Register User
	
	@PostMapping(value = "/employee/",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getUserRegistration(@RequestBody UserDTO login){
	//	login.setId(1001);
		//return new ResponseEntity<UserDTO>(login, HttpStatus.OK);
        return userService.getUserRegistration(login);

		
	}
	
	//Create a Job
	@PostMapping(value = "/employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO createEmployee(@RequestHeader("auth-token") String authToken,@RequestBody UserDTO user){
		UserDTO userDTO=new UserDTO();
//		if(authToken.equalsIgnoreCase("1000")) {
//			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
//		}
//		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
        return userService.createEmployee(authToken);

	}
	
}
