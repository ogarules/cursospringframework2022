package com.example.demo.ejercicio19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DummyRepository {
    private String connectionString;

    public String getData() {
        log.info("getting data");
        return "SELECT RESULT";  
    }
}
