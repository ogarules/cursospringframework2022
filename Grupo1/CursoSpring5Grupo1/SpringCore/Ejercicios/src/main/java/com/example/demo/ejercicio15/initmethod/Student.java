package com.example.demo.ejercicio15.initmethod;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer age;
    private String rfc;

    private StudentBook studentBook;

    @Autowired
    public void initStudent(String name, Integer age, String rfc, StudentBook studentBook) {
        this.age = age;
        this.name = name;
        this.rfc = rfc;
        this.studentBook = studentBook;
    }
}
