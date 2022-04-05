package com.example.demo.ejercicio22;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Marcador {
    @Value("0")
    private Integer goles;
}
