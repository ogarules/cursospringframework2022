package com.example.demo.ejercicio17.impl;

import com.example.demo.ejercicio17.IControllerClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
@Controller
public class ControllerClass implements IControllerClass {
    @Autowired
    private String controllerClassName;
}
