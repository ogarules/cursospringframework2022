package com.example.demo.ejercicio31.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.ejercicio29.models.Person;
import com.example.demo.ejercicio29.models.Persons;
import com.example.demo.ejercicio31.advice.RestResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
// Anotar request mapping "/rest/persons"
@RequestMapping("/rest/persons")
public class PersonsRestController {

	private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

	@PostConstruct
    private void init() {
        for (int i = 0; i < 3; i++) {
            Person p = new Person();
            p.setId(i + 1);
            p.setName("Ivan " + (i + 1));
            p.setAge(28 + i + 1);
            persons.add(p);
        }
    }

    @GetMapping    
	// Anotar request mapping "/", "", con metodo GET y produciendo json y xml
    public Persons getAllPersons() {
        return new Persons(persons);
    }

    @GetMapping("/{id}")
	// Anotar request mapping "/{id}", con metodo GET y produciendo json y xml
	// Anotar response status ok
    public Person getPerson(@PathVariable Integer id) {
        return persons.get(id - 1);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        persons.add(person);
    }
    
    @GetMapping("/getException")
	public ResponseEntity<RestResponseError> getException() {
		try {
			throw new IllegalArgumentException("Argumentos Inv�lidos");

		} catch (IllegalArgumentException ex) {
			String errorMessage = "Exception: " + ex.getMessage();

			RestResponseError rre = new RestResponseError(HttpStatus.BAD_REQUEST, errorMessage,
					ex.getClass().getSimpleName());

			return new ResponseEntity<RestResponseError>(rre, HttpStatus.BAD_REQUEST);
		}
	}

}
