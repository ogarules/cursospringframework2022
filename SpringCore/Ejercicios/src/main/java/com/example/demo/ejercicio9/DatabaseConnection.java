package com.example.demo.ejercicio9;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DatabaseConnection {
    
    private String database;
    private String user;
    private String password;
    private boolean debugMode = false;

    public void connect() {
        log.info("Connecting to {} {} {} debug mode: {}", database, user, password, debugMode);
    }

    public void disconnect() {
        log.info("Disconnecitng to {} {} {} debug mode: {}", database, user, password, debugMode);
    }
}
