package com.example.demo.ejercicio31.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.ejercicio29.models.Person;
import com.example.demo.ejercicio29.models.Persons;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Anotar Controller
@Controller
// Anotar request mapping "/persons"
@RequestMapping("/persons")
public class PersonsController {

	private static Integer nextId = 1;
	private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

	@PostConstruct
	private void init() {
		for (int i = 0; i < 3; i++) {
			Person p = new Person();
			p.setId(nextId++);
			p.setName("Ivan " + (i + 1));
			p.setAge(28 + i + 1);
			persons.add(p);
		}
	}

	// Anotar request mapping "/", "", con metodo GET y produciendo json y xml
	@RequestMapping(value = {"/", ""}, method=RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	@ResponseBody
	public Persons getAllPersons() {
		return new Persons(persons);
	}

	// Anotar request mapping "/{id}", con metodo GET y produciendo json y xml
	@RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	// Anotar response status ok
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public Person getPerson(@PathVariable Integer id) {
		return persons.get(id - 1);
	}

	// Anotar request mapping "/", "", con metodo POST y produciendo json y xml
	@RequestMapping(value = {"/", ""}, method=RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	// Anotar response status NO CONTENT
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void createPerson(@RequestBody Person person) {
		person.setId(nextId++);
		persons.add(person);
	}
	
	@RequestMapping(value = {"/{id}"}, method=RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	// Anotar response status NO CONTENT
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@ResponseBody
	public Person updatePerson(@PathVariable Integer id, @RequestBody Person person) {
		Person p = this.getPerson(id);
		p.setAge(person.getAge());
		p.setName(person.getName());
		return p;
	}

}
