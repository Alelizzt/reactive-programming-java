package com.system.flows;

import reactor.core.publisher.Flux;

public class Example07 {
	public static void main(String[] args) {
		Flux<Integer> firstFlux = Flux.just(1,2,3,4,5);
		Flux<Integer> secondFlux = Flux.just(4,5,6);
	
		firstFlux.zipWith(secondFlux, (first,second) -> first * second)
			.subscribe(System.out::println);
	}
}
