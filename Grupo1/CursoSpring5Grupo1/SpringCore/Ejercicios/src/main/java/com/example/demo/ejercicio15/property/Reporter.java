package com.example.demo.ejercicio15.property;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Reporter {
    @Autowired
    private String name;
    @Autowired
    private Integer age;
    private String rfc;

    @Autowired
    private Booklet booklet;
    @Autowired
    private Pencil pencil;
}
