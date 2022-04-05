package com.example.demo.ejercicio21.methodreplacement;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SportsCar {
    private String model;

    public int run() {
        int milis = 120;

        log.info("{} traveling at {} mph", model, milis);

        return milis;
    }
}
