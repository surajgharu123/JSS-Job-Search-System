package com.jss.jobseeker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



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

	@Override
	public boolean isTokenValidForEmployee(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity(headers);

		ResponseEntity<Boolean> response = this.restTemplate.exchange(
				"http://localhost:5500/jss/user/auth-token/validation/employee", HttpMethod.POST, httpEntity,
				Boolean.class);

		return response.getBody();
	}

	@Override
	public boolean isTokenValidForJobseeker(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", authToken);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
				"http://localhost:5500/jss/user/auth-token/validation/jobseeker", HttpMethod.POST, httpEntity,
				Boolean.class);

		return responseEntity.getBody();
	}

	@Override
	public String getUserName(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", authToken);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				"http://localhost:5500/jss/user/jobseeker/username/", HttpMethod.POST, httpEntity,
				String.class);

		return responseEntity.getBody();
	}

}
