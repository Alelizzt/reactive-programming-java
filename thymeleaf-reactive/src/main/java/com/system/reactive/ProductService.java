package com.system.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Flux<Product> findAll() {
		Flux<Product> flux1 = productRepository.searchAll();
		Flux<Product> flux2 = productRepository.searchOthers();

		return Flux.merge(flux1, flux2);
	}
}
