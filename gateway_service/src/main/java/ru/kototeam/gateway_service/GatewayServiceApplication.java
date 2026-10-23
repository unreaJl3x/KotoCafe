package ru.kototeam.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayServiceApplication {

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("cats_service_route",route->{
					return route.path("/cats").filters(r->r.addRequestHeader("GATEWAY", "1")).uri("lb://CATS-SERVICE");
				})
		.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}

