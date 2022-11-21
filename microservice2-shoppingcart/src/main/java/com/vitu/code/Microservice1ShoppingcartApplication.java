package com.vitu.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservice1ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1ShoppingcartApplication.class, args);
	}

}
