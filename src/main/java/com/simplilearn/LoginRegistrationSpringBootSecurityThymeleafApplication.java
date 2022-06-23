 package com.simplilearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginRegistrationSpringBootSecurityThymeleafApplication {

	
	public static Logger logger=LoggerFactory.getLogger(LoginRegistrationSpringBootSecurityThymeleafApplication.class);
	
	public static void main(String[] args) {
		logger.info("Application started successfully");
		SpringApplication.run(LoginRegistrationSpringBootSecurityThymeleafApplication.class, args);
		logger.info("Application finished");
	}

}
