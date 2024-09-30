package com.system.flows;

import reactor.core.publisher.Flux;

public class Example06 {
	public static void main(String[] args) {
		Flux<String> firstFlux = Flux.fromArray(new String[] {"A","B","C"});
		Flux<String> secondFlux = Flux.fromArray(new String[] {"D","E","F"});
	
		Flux.zip(firstFlux, secondFlux, (first,second) -> first + second)
			.subscribe(System.out::println);
	}
}
