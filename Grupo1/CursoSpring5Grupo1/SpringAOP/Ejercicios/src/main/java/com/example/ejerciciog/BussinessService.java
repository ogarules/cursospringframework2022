package com.example.ejerciciog;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BussinessService {
    
    @MonitorPerformance
    public void execute() {
        log.info("Starting execution...");
        log.info("EXECUTING!!!!");
        log.info("Finishing execution...");
    }
}
