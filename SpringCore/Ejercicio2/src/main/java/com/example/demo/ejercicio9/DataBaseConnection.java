package com.example.demo.ejercicio9;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DataBaseConnection {
    private String database;
    private String user;
    private String password;
    private boolean debugMode = false;

    public void connect() {
        log.info("Connectin {} {} {} debug mode: {}", database, user, password, debugMode);

    }

    public void disconnect() {
        log.info("Disconnecting {} {} {} debug mode: {}", database, user, password, debugMode);
    }
}
