package com.example.demo.ejercicio10;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Worker implements IWorker{
    private String name;
    private int age;

    public Worker() {
        this.name = "El oga";
        age = 21;

        log.info("Constructor - Worker name {}", name);
        log.info("Constructor - Worker age {}", age);
    }

    @Override
    public void init() {
        log.info("Initialzing worker");

        log.info("Worker name {}", name);

        name = "Otro oga";

        log.info("Worker name {}", name);

    }
    
    @Override
    public void destroy() {
        log.info("Killing worker....");
        
    }
    @Override
    public void showInfo() {
        log.info("Worker info - name: {} age {}", name, age);
        
    }
   
    
}
