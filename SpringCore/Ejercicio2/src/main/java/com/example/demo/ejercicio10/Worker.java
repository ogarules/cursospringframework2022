package com.example.demo.ejercicio10;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Worker implements IWorker {
    private int age;
    private String name;
    
    public Worker() {
        name = "OGA";
        age = 21;
        log.info("Constructing worker {} age {}", name, age);
    }

    @Override
    public void init() {
        log.info("Initializing worker {} ....", name);
        name = "otro oga distinto";

        log.info("Worker initialized to {}", name);

    }

    @Override
    public void showInfo() {
        log.info("Worker info: name => {} , age => {} ", name, age);
    }
    @Override
    public void destroy() {
        log.info("Killing worker....");
    }
}
