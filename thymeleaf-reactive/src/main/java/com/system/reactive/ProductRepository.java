package com.system.reactive;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public class ProductRepository {

	private static List<Product> list = new ArrayList<Product>();
	private static List<Product> list2 = new ArrayList<Product>();
	
	static {
		list.add(new Product(1,"computer",200));
		list.add(new Product(2,"tablet",300));
		list.add(new Product(3,"headphones",200));
		
		list2.add(new Product(4,"smartphone",200));
		list2.add(new Product(5,"keyboard",30));
		list2.add(new Product(6,"mouse",20));
	}
	
	public Flux<Product> searchAll() {
		return Flux.fromIterable(list).delayElements(Duration.ofSeconds(3));
	}
	
	public Flux<Product> searchOthers() {
		return Flux.fromIterable(list2).delayElements(Duration.ofSeconds(3));
	}
}
