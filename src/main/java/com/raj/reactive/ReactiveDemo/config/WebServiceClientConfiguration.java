package com.raj.reactive.ReactiveDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebServiceClientConfiguration {

	@Bean(name="webservice-web-client")
	public WebClient WebServiceWebClient() {
		WebClient webClient = WebClient
				.builder()
				.baseUrl("http://localhost")
				.build();
		return webClient;
	}
	
}