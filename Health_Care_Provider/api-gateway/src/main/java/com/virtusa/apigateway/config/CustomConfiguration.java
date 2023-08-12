package com.virtusa.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route(healthcareproviderRoute->healthcareproviderRoute.path("/api/providers/**")
			    .uri("lb://HEALTHCARE-PROVIDER-SERVICE")).build();
		
	}
}
