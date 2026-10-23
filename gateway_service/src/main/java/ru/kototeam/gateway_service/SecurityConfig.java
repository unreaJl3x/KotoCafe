package ru.kototeam.gateway_service;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {
	@Bean
	public SecurityWebFilterChain securityFilter(ServerHttpSecurity http) throws Exception {
		return http
			.csrf(c->c.disable())
			.authorizeExchange(req->
				req.anyExchange().permitAll()
			)
		.build();
	}
} 