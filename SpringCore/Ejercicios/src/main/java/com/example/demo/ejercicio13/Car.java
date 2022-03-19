package com.example.demo.ejercicio13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Engine engine;
    private WheelGroup wheelGroup;
}
