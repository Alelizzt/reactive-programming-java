package com.system.publishers;

import java.time.Duration;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class Example02 {

	// Using hot publishers
	public static void main(String[] args) throws InterruptedException {
		Flux<String> netFlux = Flux.fromStream(Example02::getVideo)
				.delayElements(Duration.ofSeconds(2))
				.share();
		
		netFlux.subscribe(part -> System.out.println("Subscriber 1: " + part));
		
		Thread.sleep(5000);
		
		netFlux.subscribe(part -> System.out.println("Subscriber 2: " + part));
		
		Thread.sleep(60000);
	}
	
	private static Stream<String> getVideo() {
		System.out.println("Request to load video");
		return Stream.of("part 1", "part 2", "part 3", "part 4", "part 5");
	}
}
