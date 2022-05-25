package com.example.demo.ejercicio15.required;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Cameraman {
    private String name;
    private Integer age;
    private String rfc;

    @Autowired
    public Cameraman(String name, String rfc) {
        this.name = name;
        this.rfc = rfc;
    }
}
