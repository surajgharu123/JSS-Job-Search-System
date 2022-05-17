
package com.jss.jobseeker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JssJobSeekerApplication {

	//Hello World Hello Hoi
	public static void main(String[] args) {
		SpringApplication.run(JssJobSeekerApplication.class, args);
	}
	
	
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
