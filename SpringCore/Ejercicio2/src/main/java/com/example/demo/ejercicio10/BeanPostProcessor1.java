package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor1 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 1 before init");

        if (bean instanceof Worker) {
            Worker worker = (Worker) bean;

            log.info("PP1 Worker name: {}", worker.getName());

            worker.setName("Otro oga");

            log.info("PP1 Worker name: {}", worker.getName());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 1 after init");

        if (bean instanceof Worker) {
            Worker worker = (Worker) bean;

            log.info("PP1 Worker name: {}", worker.getName());

            worker.setName("Otro oga after");

            log.info("PP1 Worker name: {}", worker.getName());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
    
}
