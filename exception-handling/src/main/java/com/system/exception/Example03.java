package com.system.exception;

import reactor.core.publisher.Flux;

public class Example03 {
	public static void main(String[] args) {
		
		Flux.just(2,0,7,10,8,12,22,24)
			.map(element -> {
				if(element == 0) {
					throw new RuntimeException("Exception ocurred!");
				}
				return element;
			}).onErrorContinue((ex,element) -> {
				System.out.println("Exception: " + ex);
				System.out.println("Element cause: " + element);
			})
		.log()
		.subscribe();
	}
}
