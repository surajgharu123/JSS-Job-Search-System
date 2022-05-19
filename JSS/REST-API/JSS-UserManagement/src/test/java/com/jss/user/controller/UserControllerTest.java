package com.jss.user.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jss.user.dto.UserJobSeekerDTO;
import com.jss.user.service.UserJobSeekerService;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(UserController.class)

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
	
	@MockBean
	UserJobSeekerService userJobSeekerService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	public void testAuthenticateUserJobLogin() throws Exception{
		
		UserJobSeekerDTO user=new UserJobSeekerDTO();
		user.setUsername("prashant12");
		user.setPassword("prashant@23");
		
		when(this.userJobSeekerService.authenticateUserJobLogin(user)).thenReturn(user.getUsername());
		
		MvcResult mvcResult=this.mockMvc.perform(post("http://localhost:5300/jss/user/job/authenticate")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user))
				)
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("prashant12")))
				.andReturn();
			
				String response=mvcResult.getResponse().getContentAsString();
				assertEquals(response.contentEquals("prashant12"),true);

	}
	
	@Test
	public void testRegisterUserJobSeeker() throws Exception{
		
		UserJobSeekerDTO user=new UserJobSeekerDTO();
		user.setName("prashant12");
		user.setEmail("prashant@23");
		
		when(this.userJobSeekerService.registerUserJobSeeker(user)).thenReturn(user);
		
		MvcResult mvcResult=this.mockMvc.perform(post("http://localhost:5300/jss/user/job/register")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user))
				)
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("prashant@23")))
				.andReturn();

				String response=mvcResult.getResponse().getContentAsString();
				assertEquals(response.contains("prashant@23"),true);
		
		
	}

	



}
