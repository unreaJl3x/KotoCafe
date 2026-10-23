package ru.kototeam.eureka_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityChain {
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		return http
				.csrf(c->c.disable())
				.authorizeHttpRequests(r->
					r.anyRequest().permitAll()
		).build();
	}
}
