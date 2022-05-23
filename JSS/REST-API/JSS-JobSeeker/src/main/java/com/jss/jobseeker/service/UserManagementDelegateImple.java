package com.jss.jobseeker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class UserManagementDelegateImple implements UserManagementDelegate {

	@Autowired
	RestTemplate restTemplate;

	@CircuitBreaker(name = "AUTH_TOKEN_VALIDATION_FOR_EMPLOYEE",fallbackMethod = "fallbackIsTokenValid")
	@Override
	public boolean isTokenValidForEmployee(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity(headers);

		ResponseEntity<Boolean> response = this.restTemplate.exchange(
				"http://API-GATEWAY/jss/user/auth-token/validation/employee", HttpMethod.POST, httpEntity,
				Boolean.class);

		return response.getBody();
	}
	

	@CircuitBreaker(name = "AUTH_TOKEN_VALIDATION_FOR_JOBSEEKER",fallbackMethod = "fallbackIsTokenValid")
	@Override
	public boolean isTokenValidForJobseeker(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", authToken);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
				"http://API-GATEWAY/jss/user/auth-token/validation/jobseeker", HttpMethod.POST, httpEntity,
				Boolean.class);

		return responseEntity.getBody();
	}

	public boolean fallbackIsTokenValid(String authToken,Exception exception) {
		System.out.println("JSS-JobSeeker-Login failed -Inside fallbackIsTokenValid");
		return false;
		}
	
	//@CircuitBreaker(name = "GET_DATA_FROM_DIFFERENT_TABELS",fallbackMethod = "fallbackIsbringData")
	@Override
	public String getUserName(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", authToken);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				"http://API-GATEWAY/jss/user/jobseeker/username/", HttpMethod.POST, httpEntity,
				String.class);

		return responseEntity.getBody();
	}
	
	public boolean fallbackIsbringData(String authToken,Exception exception) {
		System.out.println("JSS-JobSeeker-Data failed -Inside fallbackIsbringData");
		return false;
		}
	
	
	

}
