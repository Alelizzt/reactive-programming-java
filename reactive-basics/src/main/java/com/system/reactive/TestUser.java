package com.system.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;

public class TestUser {

	private static final Logger log = LoggerFactory.getLogger(TestUser.class);

	public static void main(String[] args) {
		Flux<String> names = Flux.just("Alex Marin", "Juan Gutierrez" ,"Mariana Pajon", "Juan Pablo", "Aghata Chrisner",
				"Lizbeth Moralez");
		Flux<User> users = names
				.map(name -> new User(name.split(" ")[0].toUpperCase(), name.split(" ")[1].toUpperCase()))
				.filter(user -> !user.getLastname().equalsIgnoreCase("Pajon"))
				.doOnNext(user -> {
					if(user == null) {
						throw new RuntimeException("Names can't be empty!");
					}
					System.out.println(user.getName().concat(" ").concat(user.getLastname()));
				})
				.map(user -> {
					String name = user.getName().toLowerCase();
					user.setName(name);
					return user;
				});
		
		users.subscribe(e -> log.info(e.toString()), error -> log.error(error.getMessage()), new Runnable() {
			
			@Override
			public void run() {
				log.info("Observanble finished!!");
				
			}
		});
	}
}
