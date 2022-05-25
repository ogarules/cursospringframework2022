package com.example.demo.ejercicio7;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Engine {
    private String serial;
    private int cylinderNumber;
    private int hp;

    public Engine() {
        log.info("Constructing engine...");
    }
}
