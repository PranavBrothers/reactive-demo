package com.raj.reactive.ReactiveDemo.service;

import java.math.BigDecimal;
import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.reactive.ReactiveDemo.bean.SearchResult;

import reactor.core.publisher.Flux;

@RestController
public class FlightSearchController {

	@GetMapping(value = "/flight/webservice", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<SearchResult> getResults() {
		return Flux
				.just(new SearchResult("Air India", new BigDecimal("100")), 
						new SearchResult("American Airlines", new BigDecimal("150")), 
						new SearchResult("Air Arabia", new BigDecimal("200")),
						new SearchResult("Jazeera Airways", new BigDecimal("250")), 
						new SearchResult("Fly Dubai", new BigDecimal("300")),
						new SearchResult("Gulf Air", new BigDecimal("350")))
				.delayElements(Duration.ofSeconds(3));
	}
}
