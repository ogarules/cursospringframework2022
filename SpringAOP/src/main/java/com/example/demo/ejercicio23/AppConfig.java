package com.example.demo.ejercicio23;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.demo.ejercicio23", "com.example.demo.util"})
public class AppConfig {
    
}
