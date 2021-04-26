package com.raj.reactive.ReactiveDemo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.raj.reactive.ReactiveDemo.bean.SearchResult;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class SearchWebService {
	
	@Qualifier("webservice-web-client")
	private final WebClient webClient;

	@GetMapping(value = "/flight/results", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<SearchResult> getResults(){
		return webClient.get().uri("/flight/webservice").retrieve().bodyToFlux(SearchResult.class);
	}
	
}