package com.example.demo.ejercicio19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "classpath:spring/ejercicio19/beans.xml"})
public class RepositoryConfig {
    
    @Bean
    public DummyRepository dummyRepository(String connectionString) {
        DummyRepository repository = new DummyRepository();
        repository.setConnectionString(connectionString);

        return repository;
    }
}
