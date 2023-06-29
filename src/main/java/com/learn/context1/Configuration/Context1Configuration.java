package com.learn.context1.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.learn.context1.beans.A;

@Configuration
@ComponentScan(basePackages = "com.learn.context1")
@EnableWebMvc
//@EnableWebSecurity
public class Context1Configuration {

	
	public A getA() {
		return new A();
	}
	
	
	
	
}
