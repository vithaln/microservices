package com.vitu.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient

public class Microservice1PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1PaymentServiceApplication.class, args);
	}
	@Bean
	
public RestTemplate restTemplate() {
	
	return new RestTemplate();
}
}
