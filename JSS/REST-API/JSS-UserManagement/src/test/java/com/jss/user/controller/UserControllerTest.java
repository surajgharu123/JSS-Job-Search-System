package com.jss.user.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jss.user.dto.UserJobSeekerDTO;
import com.jss.user.service.UserJobSeekerService;

@WebMvcTest(UserController.class)
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
		
		MvcResult mvcResult=this.mockMvc.perform(get("http://localhost:5300/jss/user/job/authenticate")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user))
				)
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("prashant")))
				.andReturn();
			
				String response=mvcResult.getResponse().getContentAsString();
				assertEquals(response.contains("prashant"),true);
	}
	
	@Test
	public void testRegisterUserJobSeeker() throws Exception{
		
		UserJobSeekerDTO user=new UserJobSeekerDTO();
		user.setUsername("prashant12");
		user.setPassword("prashant@23");
		
		when(this.userJobSeekerService.registerUserJobSeeker(user)).thenReturn(user);
		
		MvcResult mvcResult=this.mockMvc.perform(post("http://localhost:5300/jss/user/job/register")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(user))
				)
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("prashant12")))
				.andReturn();

				String response=mvcResult.getResponse().getContentAsString();
				assertEquals(response.contains("prashant@23"),true);
		
		
	}

}
