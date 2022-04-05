package com.example.demo.ejercicio17.impl;

import com.example.demo.ejercicio17.IRestControllerClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
public class RestControllerClass implements IRestControllerClass {
    @Autowired
    private String restControllerClassName;
}
