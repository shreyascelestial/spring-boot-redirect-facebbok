package com.example.springbootfacebookredirect;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@SuppressWarnings("deprecation")
@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {
	
	 protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests(a -> a
	            .antMatchers("/", "/error","/webjars/**").permitAll()
	            .anyRequest().authenticated()
	            )
	            .exceptionHandling(e -> e
	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	            )
	            .oauth2Login();
	    }
	
}
