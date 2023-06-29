package com.learn.context2.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learn.context2.beans.A;

@Configuration
@ComponentScan(basePackages = "com.learn.context2")
public class Context2Configuration {

	@Bean
	public A getA() {
		return new A();
	}
	
}
