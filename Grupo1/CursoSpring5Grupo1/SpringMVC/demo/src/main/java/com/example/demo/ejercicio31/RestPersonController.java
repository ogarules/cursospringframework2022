package com.example.demo.ejercicio31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.ejercicio29.model.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/rest/persons")
public class RestPersonController {
    
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void init() {
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setId(i + 1);
            person.setAge(10 * i);
            person.setName("oga" + i);
            persons.add(person);
        }
    }

    @GetMapping
    public List<Person> GetAllPersons() {
        return persons;
    }
    
    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return persons.get(id - 1);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person entity) {        
        persons.add(entity);
        entity.setId(persons.size() + 1);
        
        return entity;
    }
    
}
