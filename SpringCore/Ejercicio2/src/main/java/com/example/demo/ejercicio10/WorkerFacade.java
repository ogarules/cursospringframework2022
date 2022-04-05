package com.example.demo.ejercicio10;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class WorkerFacade implements IWorker {
    private String name;
    private int age;

    private IWorker originalWorker;

    public void setOriginalWorker(IWorker original) {
        this.originalWorker = original;
        this.name = original.getName();
        this.age = original.getAge();
    }

    public WorkerFacade() {
        log.info("Worker Facade - Constructing worker");
    }

    @Override
    public void init() {
        log.info("Worker facade initializing....");
    }

    @Override
    public void showInfo() {
        log.info("Worker facede info: {} age {}", name, age );
        this.originalWorker.showInfo();
    }

    @Override
    public void destroy() {
        log.info("Worker facade destroying");
        
    }
}
