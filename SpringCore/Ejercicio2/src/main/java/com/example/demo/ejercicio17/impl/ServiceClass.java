package com.example.demo.ejercicio17.impl;

import com.example.demo.ejercicio17.IServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class ServiceClass implements IServiceClass {
    @Autowired
    private String serviceClassName;
}
