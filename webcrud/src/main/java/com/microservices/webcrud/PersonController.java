package com.microservices.webcrud;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.webcrud.jpa.Person;
import com.microservices.webcrud.jpa.PersonRepository;

@RestController
@RequestMapping("/v1")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value = "/person",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Person>> getUsers(final HttpServletRequest httpServletRequest){
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(persons::add);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

}
