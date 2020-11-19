package com.tts.subscriberList;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.subscriberList.subscriber.Subscriber;
import com.tts.subscriberList.subscriber.SubscriberRepository;

@SpringBootApplication
public class SubscriberListApplication {
	private static final Logger log = LoggerFactory.getLogger(SubscriberListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SubscriberListApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(SubscriberRepository repository) {
		return (args) -> {
			// save some subscribers
			// repository.save(new Subscriber("Michael", "Smith", "msmith", new Date(System.currentTimeMillis())));
			// repository.save(new Subscriber("Aaron", "Kim", "akim", new java.util.Date(System.currentTimeMillis())));
			// repository.save(new Subscriber("Kim", "Lassiter", "klassiter", new java.util.Date(System.currentTimeMillis())));
			// repository.save(new Subscriber("Joan", "Daniels", "jdaniels", new java.util.Date(System.currentTimeMillis())));
			// repository.save(new Subscriber("Eric", "Patterson", "epatterson", new java.util.Date(System.currentTimeMillis())));

			// read all subscribers
			log.info("Subscribers found with findAll():");
			log.info("-------------------------------");
			for (Subscriber subscriber : repository.findAll()) {
				log.info(subscriber.toString());
			}
			log.info("");

			// read an individual subscriber by ID
			repository.findById(1L).ifPresent(subscriber -> {
				log.info("Subscriber found with findById(1L):");
				log.info("--------------------------------");
				log.info(subscriber.toString());
				log.info("");
			});

			// read subscribers by username
			log.info("Subscriber found with findByUserName('epatterson'):");
			log.info("---------------------------------------------");
			repository.findByUserName("epatterson").forEach(user -> {
				log.info(user.toString());
			});
			log.info("");

			// read subscribers by last name
			log.info("Subscribers found with findByLastName('Kim'):");
			log.info("------------------------------------------");
			repository.findByLastName("Kim").forEach(user -> {
				log.info(user.toString());
			});
			log.info("");

		};
	}
}
