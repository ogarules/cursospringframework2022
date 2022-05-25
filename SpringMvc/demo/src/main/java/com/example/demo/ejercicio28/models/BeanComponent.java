package com.example.demo.ejercicio28.models;

import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

	public String sayHello(String name) {
		return "Hello " + name + " !";
	}

}
