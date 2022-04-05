package com.example.demo.ejercicio12;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class AddressBook {
    private List<Address> addresses;
    private Set<Phone> phones;
    private Map<Integer, String> emergencyNumbers;
    private Properties family;

    private Integer[] numbers;
    private String[] notes;
    private Person[] persons;

}
