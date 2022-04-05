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
    private Subject otherSubject;

    @PostConstruct
    public void postConstructCallBack() {
        log.info("Initializing bean...");
    }
    
    @PreDestroy
    public void preDestroyCallback() {
        log.info("Destroying bean...");
    }
}
