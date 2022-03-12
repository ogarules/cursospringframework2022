package com.example.demo.ejercicioa;

import org.springframework.context.Lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LyfeCycleDemo implements Lifecycle {
    
    private boolean isRunning = false;

    @Override
    public void start() {
        log.info("Starting lifecycle demo...");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("Stoping lifecycle demo...");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        log.info("Checking if bean is running...");
        return isRunning;
    }
    
}
