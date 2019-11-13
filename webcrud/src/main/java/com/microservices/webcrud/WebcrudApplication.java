package com.microservices.webcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.webcrud.jpa.Person;
import com.microservices.webcrud.jpa.PersonRepository;

@SpringBootApplication
public class WebcrudApplication implements CommandLineRunner {
	
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebcrudApplication.class, args);
	}

	@Override
	public void run(String... args) {

		personRepository.save(new Person("Manik"));
		personRepository.save(new Person("Rohit"));
		personRepository.save(new Person("Balaji"));
		
		
		System.out.println("\nfindAll()");
		personRepository.findAll().forEach(x -> System.out.println(x));
		
		System.out.println("\nfindById(1L)");
		personRepository.findById(1l).ifPresent(x -> System.out.println(x));
		
		System.out.println("\nfindByName('Manik')");
		personRepository.findByName("Manik").forEach(x -> System.out.println(x));
		
	}

}
