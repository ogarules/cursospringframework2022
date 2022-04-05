package com.example.demo.ejercicio19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DummyRepository {
    private String connectionString;

    public String getData() {
        log.info("Getting repository data...");

        return "SELECT RESULT";
    }
}
