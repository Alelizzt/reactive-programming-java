package com.system.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example01 {
	public static void main(String[] args) {
		
		List<Integer> elementsFromMono = new ArrayList<>();
		List<Integer> elementsFromFlux = new ArrayList<>();
		
		// Create mono
		Mono<Integer> mono = Mono.just(121);
		
		// Create flux
		Flux<Integer> flux = Flux.just(12,14,15,52,21,6,1);
		
		// Subscribe mono 
		mono.subscribe(elementsFromMono::add);
		
		// Subscribe flux
		flux.subscribe(elementsFromFlux::add);
		
		System.out.println(elementsFromMono);
		System.out.println(elementsFromFlux);
		
	}
}
