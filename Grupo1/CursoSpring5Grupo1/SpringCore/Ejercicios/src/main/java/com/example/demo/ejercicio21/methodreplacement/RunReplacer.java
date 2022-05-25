package com.example.demo.ejercicio21.methodreplacement;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        int milis = 200;

        SportsCar car = (SportsCar) obj;
        log.info("Replaced: {} running at {}", car.getModel(), milis);

        return milis;
    }
    
}
