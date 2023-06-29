package com.learn.springBoot;

import javax.servlet.Servlet;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.learn.context1.Configuration.Context1Configuration;
import com.learn.context1.beans.A;
import com.learn.context2.Configuration.Context2Configuration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class, DispatcherServletAutoConfiguration.class,ErrorMvcAutoConfiguration.class})
@RestController
public class Application {
	
	@Value("${message}")
	String message;
	
//	@Autowired
//	A a;
	
	Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("check")
	public String check() {
		logger.info("Message");
		return message;
	}
	
	@Bean
	public PasswordEncoder e() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
    public ServletRegistrationBean<DispatcherServlet> foo() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(Context1Configuration.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, "/c1/*");
        servletRegistrationBean.setName("DispatcherServletOne");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
	
	@Bean
    public ServletRegistrationBean<DispatcherServlet> bar() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(Context2Configuration.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, "/c2/*");
        servletRegistrationBean.setName("DispatcherServletTwo");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
	
	@Bean
	public B getB() {
		return new B();
	}

}
