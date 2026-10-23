package ru.kototeam.users_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	/*
	 * @Bean PasswordEncoder passwordEncoder;
	 */
	
	@Bean
	public SecurityFilterChain securityFlter (HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(a->a.anyRequest().permitAll()).build();
	}
}
