package com.example.demo.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorld {
    private String mensaje;

    public HelloWorld() {
        
    }

    public HelloWorld(String mensaje) {
        this.mensaje = mensaje;
    }
}
