package com.vitu.code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@RestController
public class Shopping {
	
	 Logger log=LoggerFactory.getLogger(Shopping.class);
	 
	 @Bean
		public Sampler sBean() {
			return Sampler.ALWAYS_SAMPLE;
		}
	@GetMapping("/shop")
	public String shops() {
		return "SHOPPING0CART WILL BE AVAILABLE SOON...THANKS FOR THE VISITING WITH US!";
	}

	@GetMapping("/micro2")
	public String micro2() {
		log.info("microservie2=============================");
		return "micro-service2";
	}
	
	//resilence4J
	@GetMapping("/service1")
	public String resilence4j() {
		
		return "This is for the resilence from Shopping-cart Service";
	}

}
