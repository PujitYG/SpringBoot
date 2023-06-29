package com.learn.context1.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.learn.springBoot.Roles;

//@Configuration
//@EnableWebSecurity
public class Context1SecurityConfig {
	
	@Autowired
	PasswordEncoder pe;
	
	

	@Bean
	public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
	
		http.csrf()
		.disable()
		.antMatcher("/c1/**")
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return http.build();
	} 
	
	
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user1 = User.builder()
				.username("user")
				.password(pe.encode("password123"))
				.authorities(Roles.USER.getPermission())
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(pe.encode("password123"))
				.authorities(Roles.ADMIN.getPermission())
				.build();
		
		return new InMemoryUserDetailsManager(user1,admin);
	}
	

	
}
