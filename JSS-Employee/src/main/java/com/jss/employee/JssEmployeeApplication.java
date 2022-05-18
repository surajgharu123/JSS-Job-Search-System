package com.jss.employee;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
public class JssEmployeeApplication {

	//Hello Second Update commit new
	public static void main(String[] args) {
		SpringApplication.run(JssEmployeeApplication.class, args);
	}
	
	

	@Bean
	public ModelMapper getMapping() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Docket getCuttomizedDocket() {
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(RequestHandlerSelectors.basePackage("com.jss.employee"))
	//.paths(PathSelectors.ant("/stock/*"))
	.paths(PathSelectors.any())
	.build().apiInfo(getInfo());
	}
	
	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo = new ApiInfo("Swagger Restful Api Documentation",
				"This page given REST API Documentation for Jss(Job Search Employee)", 
				"2.5", "My Teams of Service", 
				new Contact("Shubham", "http://ShubhamKGupta.com", "Shubham@gmail.com"), 
				"GPL", 
				"http://gpl.org"
				,new ArrayList<VendorExtension>());
		return apiInfo;
	} 

}
