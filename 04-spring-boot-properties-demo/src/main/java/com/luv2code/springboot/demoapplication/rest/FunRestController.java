package com.luv2code.springboot.demoapplication.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@Value("${coach.Name}")
	private String name;
	
	@Value("${coach.Team}")
	private String teamName;
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Time on the Server is "+LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "junaid";
	}
	
	@GetMapping("/details")
	public String teamDetails() {
		
		return "Playes with name "+name+" plays for "+teamName;
	}
}
