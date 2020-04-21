package com.example.trainerplanner.model.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
							
				.antMatchers("/admin/**", "/delete/**").hasRole("ADMIN") //Tarvitsee adminin kyseisiin URL:hin
				.antMatchers("/trainerlist", "/add", "/save").permitAll() //Kuka vain pääsee
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
}
