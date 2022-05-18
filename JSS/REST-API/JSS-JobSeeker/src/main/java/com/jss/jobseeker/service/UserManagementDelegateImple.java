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
	public boolean isTokenValid(String authToken) {
		// TODO Auto-generated method stub
		HttpHeaders headers= new HttpHeaders();
		headers.set("Authorization", authToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity(headers);
		
		ResponseEntity<Boolean> response = 
				restTemplate.exchange("http://localhost:5300/jss/user/job/authenticate", HttpMethod.POST, httpEntity, Boolean.class);
		return response.getBody();
	}

}
