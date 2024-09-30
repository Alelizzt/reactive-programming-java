package com.system.flows;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example03 {
	public static void main(String[] args) {
		
		Flux.fromArray(new String[] {"Tom", "Melissa", "Steve", "Megan"})
				.flatMap(Example03::addNameWithMono)
				.subscribe(System.out::println);
	}
	
	private static Mono<String> addNameWithMono(String name) {
		return Mono.just(name.concat(" modified"));
	}
}
