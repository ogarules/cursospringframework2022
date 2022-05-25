package com.example.demo.ejercicio10;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class WorkerFacade implements IWorker {
    private String name;
    private int age;

    private IWorker originalWorker;

    public WorkerFacade() {
        log.info("WorkerFacade - Constructing facade...");
    }

    public void setOriginalWorker(IWorker originalWorker) {
        this.originalWorker = originalWorker;

        age = originalWorker.getAge();
        name = originalWorker.getName();
    }

    @Override
    public void init() {
        log.info("Initialzing facade worker");
    }
    
    @Override
    public void destroy() {
        log.info("Killing facade worker....");
        
    }
    @Override
    public void showInfo() {
        log.info("Facade Worker info - name: {} age {}", name, age);
        this.originalWorker.showInfo();
    }
   
}
