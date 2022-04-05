package com.example.demo.ejerciciod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ValuesClass {
    @Value("${programmer.name}")
    private String name;

    @Value("${programmer.age}")
    private Integer age;
}
