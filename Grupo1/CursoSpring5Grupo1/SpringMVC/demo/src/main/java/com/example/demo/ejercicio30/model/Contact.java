package com.example.demo.ejercicio30.model;

import java.util.List;

import lombok.Data;

@Data
public class Contact {
    private String name;
    private String email;
    private String gender;
    private String password;
    private String confirmPassword;
    private List<String> courses;
    private String tutor;
    private String hiddenMessage;
}
