package com.system.step;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TestExamples {

	@Test
	public void testFlux() {
		Flux<Integer> fluxToTest = Flux.just(1,2,3,4,5);
		
		//Create test
		StepVerifier.create(fluxToTest)
			.expectNext(1)
			.expectNext(2)
			.expectNext(3)
			.expectNext(4)
			.expectNext(5)
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testFluxString() {
		Flux<String> fluxToTest = Flux.just("Jessica", "Tomas", "John", "Steve", "Megan", "Monica", "Henry")
				.filter(name -> name.length() <= 5)
				.map(String::toUpperCase);
		
		StepVerifier.create(fluxToTest)
			.expectNext("TOMAS")
			.expectNext("JOHN")
			.expectNextMatches(name -> name.startsWith("ST"))
			.expectNext("MEGAN")
			.expectNext("HENRY")
			.expectComplete()
			.verify();
		
	}
}
