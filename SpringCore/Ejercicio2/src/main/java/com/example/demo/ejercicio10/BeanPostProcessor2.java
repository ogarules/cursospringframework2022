package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor2 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 2 before init");

        if (bean instanceof Worker) {
            Worker worker = (Worker) bean;

            log.info("PP2 Worker nage: {}", worker.getName());

            worker.setAge(1);

            log.info("PP2 Worker age: {}", worker.getName());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 2 after init");

        if (bean instanceof Worker) {
            Worker worker = (Worker) bean;

            log.info("PP2 Worker age: {}", worker.getName());

            worker.setAge(2);

            log.info("PP2 Worker age: {}", worker.getName());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
    
}
