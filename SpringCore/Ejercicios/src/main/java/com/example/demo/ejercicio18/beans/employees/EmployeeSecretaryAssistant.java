package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.beans.Employee;

@Named("secretaryAssistantEmployee")
public class EmployeeSecretaryAssistant extends Employee {
    
    public EmployeeSecretaryAssistant() {
        this.setName("Ale");
        this.setRfc("12345");
    }
}
