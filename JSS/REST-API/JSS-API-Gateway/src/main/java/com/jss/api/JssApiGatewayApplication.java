package com.jss.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JssApiGatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(JssApiGatewayApplication.class, args);
	}

}
