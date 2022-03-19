package com.example.demo.ejercicio17.impl;

import com.example.demo.ejercicio17.IComponentClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ComponentClass implements IComponentClass {

    @Autowired
    private String componentClassName;
}
