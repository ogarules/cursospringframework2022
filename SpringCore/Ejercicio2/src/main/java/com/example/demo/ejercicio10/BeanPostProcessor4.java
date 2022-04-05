package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor4 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 4 before init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean postprocessor 1 after init");

        if (bean instanceof Worker) {
            Worker worker = (Worker) bean;
            WorkerFacade facade = new WorkerFacade();
            facade.setOriginalWorker(worker);

            log.info("Facade Worker name: {}", facade.getName());
            log.info("Facade Worker age: {}", facade.getAge());

            bean = facade;
            return facade;
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 3;
    }
    
}
