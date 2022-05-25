package com.example.demo.ejercicio19;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public DummyService dummyService(@Qualifier("dummyRepository") DummyRepository dummyRepository) {
        DummyService service = new DummyService();
        service.setRepository(dummyRepository);

        return service;
    }
}
