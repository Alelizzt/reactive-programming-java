package com.system.back;

import java.util.ArrayList;
import java.util.Arrays;

import reactor.core.publisher.Flux;

public class Example01 {

	public static void main(String[] args) {
		Flux<String> citys = Flux.fromIterable(
				new ArrayList<>(Arrays.asList("New York", "London", "Paris", "Toronto", "Rome"))
				);
		citys.log().subscribe();
	}
}
