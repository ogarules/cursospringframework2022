package com.example.demo.ejercicio10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPostProcessor2 implements BeanPostProcessor, Ordered {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 2 Before initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker age {}", worker.getAge());

            worker.setAge(-1);

            log.info("Worker age {}", worker.getAge());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Postprocessor 2 After initialization");

        if (bean instanceof IWorker) {
            Worker worker = (Worker) bean;

            log.info("Worker age {} after", worker.getAge());

            worker.setAge(100);

            log.info("Worker age {} after", worker.getAge());
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    
}
