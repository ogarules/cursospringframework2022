package com.example.demo.ejercicio7;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Wheel {
    private String brand;
    private String material;
    private String rinSize;

    public Wheel() {
        log.info("Constructing wheel...");
    }
}
