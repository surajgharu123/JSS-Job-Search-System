package com.jss.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.core.ipc.http.HttpSender.Response;

@Service
public class EmployeeServiceDelegateImpl implements EmployeeServiceDelegate {
	
	@Autowired
	RestTemplate restTemplate;

	@CircuitBreaker(name = "AUTH_TOKEN_VALIDATION",fallbackMethod = "fallbackIsTokenValid")
	@Override
	public boolean isTokenValid(String authToken) {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	headers.set("Authorization", authToken);
	HttpEntity entity = new HttpEntity(headers);
	ResponseEntity<Boolean> response =
	this.restTemplate.exchange("http://localhost:5300/jss/user/employee/authenticate", HttpMethod.POST, entity, Boolean.class);
	
	return response.getBody();
	}
	public boolean fallbackIsTokenValid(String authToken,Exception exception) {
		System.out.println("JSS-Employee-Login failed -Inside fallbackIsTokenValid");
		return false;
	}

}
