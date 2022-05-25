package com.example.demo.ejercicio29.models;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "persons")
public class Persons {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "person")
	private List<Person> persons;

	public Persons(List<Person> persons) {
		this.persons = persons;
	}

}
