package com.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	http
		
		.authorizeRequests()	//authorize request
		.anyRequest()			//any request	
		.authenticated()		//authenticate already		
		.and()					//and
		.formLogin()
		.loginPage("/login")
		.permitAll();
	}

	
	
}