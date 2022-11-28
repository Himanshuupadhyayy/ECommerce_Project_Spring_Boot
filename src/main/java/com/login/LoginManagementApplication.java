package com.login;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginManagementApplication.class, args);
		
		System.out.println("login management Application");
	}
	
	

	
}	