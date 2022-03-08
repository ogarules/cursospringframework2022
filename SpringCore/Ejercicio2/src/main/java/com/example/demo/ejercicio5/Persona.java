package com.example.demo.ejercicio5;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Persona {
    private String nombre;

    public Persona() {
        log.info("Creando instancia de persona...");
    }
}
