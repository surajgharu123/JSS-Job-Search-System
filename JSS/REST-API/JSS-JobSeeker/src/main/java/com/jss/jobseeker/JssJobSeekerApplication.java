
package com.jss.jobseeker;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class JssJobSeekerApplication {

	//Hello World Hello Hoi
	public static void main(String[] args) {
		SpringApplication.run(JssJobSeekerApplication.class, args);
	}
	
	
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	
	@Bean
	public Docket getCuttomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jss.jobseeker"))
				//.paths(PathSelectors.ant("/stock/*"))
				.paths(PathSelectors.any())
				.build().apiInfo(getInfo());
	}

	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo = new ApiInfo("Swagger Restful Api Documentation",
				"This page given REST API Documentation for JSS-JOBSEEKER", 
				"2.5", "My Teams of Service", 
				new Contact("Job Search System", "http://jss.com", "jobsearchsystem@gmail.com"), 
				"GPL", 
				"http://gpl.org"
				,new ArrayList<VendorExtension>());
		return apiInfo;
	} 
	
	@Bean
	@LoadBalanced
	private RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
