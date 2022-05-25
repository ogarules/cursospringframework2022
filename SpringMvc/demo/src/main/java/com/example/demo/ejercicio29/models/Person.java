package com.example.demo.ejercicio29.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "person")
public class Person {
    private Integer id;
	private String name;
	private Integer age;
}
