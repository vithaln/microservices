package com.vitu.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservice3EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservice3EurekaServerApplication.class, args);
	}

}
