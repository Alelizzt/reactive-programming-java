package com.system.step.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleService {

	public Mono<String> searchOne() {
		return Mono.just("Hi");
	}
	
	public Flux<String> searchAll() {
		return Flux.just("Hi", "There","Friend");
	}
	
	public Flux<String> searchAllSlow() {
		return Flux.just("Hi", "There","Friend").delaySequence(Duration.ofSeconds(10));
	}
}
