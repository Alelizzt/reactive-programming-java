package com.system.reactive;

import reactor.core.publisher.Mono;

public class Example02 {

	public static void main(String[] args) {
		
		Mono<String> mono = Mono.just("Hi!");
		mono.subscribe(
					data -> System.out.println(data), //onNext
					err -> System.out.println(err),  //onError
					() -> System.out.println("Completed!") //onComplete
				);
	}
}
