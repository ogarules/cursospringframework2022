package com.example.demo.tarea2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class Agenda {
    private List<String> notas;
    private Set<Auto> autosFamilia;
    private Map<String, Integer> numeros;
    private Properties properties;

    private Persona papa;
    private Persona mama;
    private Persona hijo;
    private Persona hija;
}
