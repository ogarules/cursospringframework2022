package com.example.demo.ejercicio16;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Student {
    
    @Resource
    private String name;
    @Resource
    private String enrollment;
    @Resource
    private Subject mathematics;
    @Resource
    private Subject subject;

    @PostConstruct
    public void postConstructCallback() {
        log.info("Initializing student ....");
    }

    @PreDestroy
    public void preDestroyCallback() {
        log.info("Destroying student ....");
    }
}
