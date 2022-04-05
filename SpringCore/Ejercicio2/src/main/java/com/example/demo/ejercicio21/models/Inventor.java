package com.example.demo.ejercicio21.models;

import java.util.Date;
import java.util.GregorianCalendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventor {
    private String name;
    private String natiolality;
    private String[] inventions;
    private Date birthdate;
    private PlaceOfBirth placeOfBirth;

    public Inventor(String name, String nationality) {
        this.name = name;
        this.natiolality = nationality;
        this.birthdate = new GregorianCalendar().getTime();
    }
}
