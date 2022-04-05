package com.example.demo.ejercicio21;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.example.demo.ejercicio21")
@ImportResource(locations = "classpath:spring/ejercicio21/spel-beans.xml")
public class AppConfig {
    
}
