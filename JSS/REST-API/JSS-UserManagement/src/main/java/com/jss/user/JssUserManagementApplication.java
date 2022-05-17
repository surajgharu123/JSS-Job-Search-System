package com.jss.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.modelmapper.ModelMapper;

@SpringBootApplication
public class JssUserManagementApplication {

//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//	return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
		
	}
	public static void main(String[] args) {
		SpringApplication.run(JssUserManagementApplication.class, args);
	}
	

}
