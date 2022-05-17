package com.jss.user.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bug-fixes")
public class UserJobSeekerCustomActuator {
	
private Map<String, List<String>> userJobSeekerCustomActuator=new HashMap<>();
	
	@PostConstruct
	public void init() {
		userJobSeekerCustomActuator.put("a1", Arrays.asList("Username and password are not valid", "Invalid login credentials"));
		userJobSeekerCustomActuator.put("a2", Arrays.asList("Id is not valid", "Invalid Id"));
	}

	@ReadOperation
	public Map<String, List<String>> getAllLoginCustomActuator(){
	return userJobSeekerCustomActuator;
	}

}
