package com.raj.reactive.ReactiveDemo.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {

	private String airlineName;
	private BigDecimal fare;
	 
}
