package com.example.demo.ejercicio19;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "com.example.demo.ejercicio19" })
@Import({RepositoryConfig.class, ServiceConfig.class})
public class ApplicationConfig {
    
    @Bean
    public IQuadraticEquationService quadraticService() {
        return new QuadraticEquationService();
    }

    @Bean(initMethod ="init", destroyMethod = "destroy" )
    @Qualifier("quadraticEquationServiceBean")
    public IQuadraticEquationService quadraticService2() {
        return new QuadraticEquationService();
    }
    
    @Bean
    @Scope("prototype")
    public IQuadraticEquationService quadraticService3() {
        return new QuadraticEquationService();
    }
}
