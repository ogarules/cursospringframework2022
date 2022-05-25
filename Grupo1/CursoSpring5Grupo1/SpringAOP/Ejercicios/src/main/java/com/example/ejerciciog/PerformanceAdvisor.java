package com.example.ejerciciog;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PerformanceAdvisor implements MethodBeforeAdvice, AfterReturningAdvice {

    private long start = 0;
    private long end = 0;

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        end = System.currentTimeMillis();
        log.info("Finished executing method {} on object {} in {} seconds...",  
                method.getName(), target.getClass().getName(),
                (end-start));
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        start = System.currentTimeMillis();
        
        log.info("Executing mthod {} on object {}", method.getName(), target.getClass().getName());
    }
    
}
