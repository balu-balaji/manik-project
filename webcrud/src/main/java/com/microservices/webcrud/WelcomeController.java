package com.microservices.webcrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.webcrud.jpa.Person;
import com.microservices.webcrud.jpa.PersonRepository;

@Controller
public class WelcomeController {
	
	@Autowired
	PersonRepository personRepository;

	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "welcome";
		}
		
		@RequestMapping("/person")
		public String person(Map<String, Object> model) {
			List<Person> persons = new ArrayList<>();
			personRepository.findAll().forEach(persons::add);
			model.put("message", this.message);
			model.put("persons", persons);
			return "person";
		}
	
}
