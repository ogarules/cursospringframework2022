package com.example.demo.ejercicio15.notrequired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class Airplane {
    
    @Autowired(required = false)
    private String airplaneCode;

    @Autowired
    @Qualifier("airline2")
    private Airline airline;
}
