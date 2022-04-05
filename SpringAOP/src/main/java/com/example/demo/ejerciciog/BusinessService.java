package com.example.demo.ejerciciog;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BusinessService {
    
    @MonitorPerformance
    public void execute() {
        log.info("Starting execution...");
        log.info("Executing !!!!!!");
        log.info("Finishing execution...");
    }
}
