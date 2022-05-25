package com.example.demo.ejercicio21.methodinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SingletonBean {
    
    @Value("3")
    private @Getter @Setter Integer iterations;

    public String process(String data) {
        return getProcessor().processData(data, iterations);
    }

    // @Autowired
    // IProcessor processor;

    @Lookup("stringProcessor")
    public abstract IProcessor getProcessor();
}
