package com.example.demo.ejercicio3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Torneo {
    private String nombre;
    private Evento evento;
}
