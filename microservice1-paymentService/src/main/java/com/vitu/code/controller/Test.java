package com.vitu.code.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vitu.code.model.Amount;

import brave.sampler.Sampler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class Test {
	 Logger log=LoggerFactory.getLogger(Test.class);

	@Autowired
	private RestTemplate template;
	
	//=================================================================
	
	//circuitBreaker
	int count=1;
	
	private static final String Shopping="shopping-service";
	@GetMapping("/a")
	@CircuitBreaker(name =Shopping, fallbackMethod="shoppingServiceFallback")
	//@Retry(name = Shopping)
	//@RateLimiter(name = Shopping)
	public String test() {
		String url="http://localhost:8002/service1";
		log.info("retry mrthod is called "+ count++ +" times at "+new Date());
		return "testing went fine!!"+template.getForObject(url, String.class);
	}
	
	
	public String shoppingServiceFallback(Exception e) {
		
		return "this is a fallback method called for Payment-Service";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=============================================================
	//this is for zipkin
	
	@Bean
	public Sampler sBean() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	/*
	 * @GetMapping("/test") public String test() { String
	 * url="http://localhost:8002/shop"; return
	 * "testing went fine!!"+template.getForObject(url, String.class); }
	 */
	
	
	@GetMapping("/payment")
	public String payment() {
		return "PAYMENT-SERVICE'S testing went fine!!";
	}
	
	/**
 for zipkin
	
	1:addd dependancy spring cloud zipkin server
	2:add Sampler class in each controller where we have microservies
	3:let's start zipkin in loacally in cmd java -jar zipkin-server-2.23.19-exec.jar
	4:http://localhost:9411/zipkin
	5:now start application
	6:zipkin is used to trace the status
	
	
	*/
	
	@GetMapping("/micro1")
	public String micro1() {
		String url="http://localhost:8002/micro2";
		log.info("microservie-1=============================");

		return template.getForObject(url, String.class);
	}
	
	@PostMapping("/dopayment")
	public Amount doPayment(@RequestBody Amount amt) {
		return amt;
	}
}
