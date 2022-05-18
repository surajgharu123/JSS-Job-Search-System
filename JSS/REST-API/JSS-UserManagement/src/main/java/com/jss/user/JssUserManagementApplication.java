package com.jss.user;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;



import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


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
@EnableEurekaClient

public class JssUserManagementApplication{
	

    public static boolean switchUserDetailsService = false;
	public static void main(String[] args) {
		SpringApplication.run(JssUserManagementApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jss.user"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
		
	}
		private ApiInfo getApiInfo() {
			ApiInfo apiInfo=new ApiInfo("Stock Rest Api Documentation",
					"This page givesRest API Doucmentation ", "2.5",
					"My Terms of services",
					new Contact("Prashant Dhoke","http://prashant.com","prashant.dhoke@zensar.com"), 
					"GPL", "http://gpl.org", 
					new ArrayList<VendorExtension>());
			return apiInfo;

		}

		
		
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}


}

 