package com.example.demo.ejercicio6;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DataBaseConnection implements InitializingBean, DisposableBean {
    
    private String database;
    private String user;
    private String password;

    @Override
    public void destroy() throws Exception {
        log.info("Executing destroy of context");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Executing after setting properties");
    }
    
    public void initMethod() {
        log.info("Init-method called from container");
    }

    public void connect() {
        log.info("Connecting to => {} {} {}", database, user, password);
    }

    public void disconnect() {
        log.info("Disconnection from => {}", database);
    }
}
