package com.learn.context1.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springBoot.B;

@RestController
public class ControllerV1 {
	
	Logger log = LoggerFactory.getLogger(ControllerV1.class);

	@Autowired 
	B b;
	
	@GetMapping("/c")
	public String check() {
		log.info("This is the message");
		return b.name;
	}
	
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "this is login";
	}
	
}
