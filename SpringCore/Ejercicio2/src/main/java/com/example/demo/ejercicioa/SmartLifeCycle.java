package com.example.demo.ejercicioa;

import org.springframework.context.SmartLifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmartLifeCycle implements SmartLifecycle {
    
    private boolean isRunning = false;
    @Override
    public void start() {
        log.info("Smart life cycle starting...");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.info("Smart life cycle stoping...");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        log.info("Checkinf life cycle running...");
        return isRunning;
    }
    
}
