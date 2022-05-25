package com.example.demo.tarea3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.example.demo.tarea3"})
public class ApplicationConfig {
    @Bean
    public ICurrency getCurrencyEnglish() {
        return new CurrencyEng();
    }

    @Bean
    public ICurrency getCurrencySpanish() {
        return new CurrencyEsp();
    }

    @Bean
    public INumerical getNumericalSpanish() {
        return new NumericalEsp();
    }

    @Bean
    public INumerical getNumericalEnglish() {
        return new NumericalEng();
    }
}
