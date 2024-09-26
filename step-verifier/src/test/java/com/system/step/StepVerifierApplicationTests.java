package com.system.step;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.system.step.services.SimpleService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class StepVerifierApplicationTests {

	@Autowired
	SimpleService simpleService;

	@Test
	void testMono() {
		Mono<String> one = simpleService.searchOne();
		StepVerifier.create(one).expectNext("Hi").verifyComplete();
	}
	
	@Test
	void testSomeones() {
		Flux<String> some = simpleService.searchAll();
		StepVerifier.create(some).expectNext("Hi").expectNext("There").expectNext("Friend").verifyComplete();
	}
	
	@Test
	void testSomeonesDelayed() {
		Flux<String> some = simpleService.searchAllSlow();
		StepVerifier.create(some)
			.expectNext("Hi")
			.thenAwait(Duration.ofSeconds(1))
			.expectNext("There")
			.thenAwait(Duration.ofSeconds(1))
			.expectNext("Friend")
			.thenAwait(Duration.ofSeconds(1)).verifyComplete();
	}
}
