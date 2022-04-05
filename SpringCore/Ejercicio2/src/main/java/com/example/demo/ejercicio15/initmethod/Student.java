package com.example.demo.ejercicio15.initmethod;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String rfc;
    private Integer age;

    StudentBook studentBook;

    @Autowired
    public void intStudent(String name, String rfc, Integer age, StudentBook studentBook) {
        this.name = name;
        this.rfc = rfc;
        this.age = age;
        this.studentBook = studentBook;    
    }
}
