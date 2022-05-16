package com.jss.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JssEurekaApplication {

	//Hello
	public static void main(String[] args) {
		SpringApplication.run(JssEurekaApplication.class, args);
	}

}
