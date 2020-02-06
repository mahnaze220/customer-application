package com.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class defines user permissions for access control on rest services.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable().authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.POST,"/customerData").permitAll()
	         .antMatchers(HttpMethod.POST,"/customerMeasureData").permitAll()
	        .anyRequest().authenticated();   
	}

}
