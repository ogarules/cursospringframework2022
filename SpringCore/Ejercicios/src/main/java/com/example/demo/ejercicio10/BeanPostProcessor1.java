package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor1 implements BeanPostProcessor, Ordered {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 Before initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker name {}", worker.getName());

            worker.setName("otro oga mas");

            log.info("Worker name {}", worker.getName());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 1 After initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker name {}", worker.getName());

            worker.setName("otro oga mas after");

            log.info("Worker name {}", worker.getName());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    
}
