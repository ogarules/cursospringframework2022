package com.example.demo.ejercicio12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private int externalNumber;
    private int internalNumber;
    private String neighbor;


}
