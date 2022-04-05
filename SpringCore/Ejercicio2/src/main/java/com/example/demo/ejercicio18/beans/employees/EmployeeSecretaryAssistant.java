package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.beans.Employee;

@Named("secretaryAssistantEmployee")
public class EmployeeSecretaryAssistant extends Employee {
    
    public EmployeeSecretaryAssistant() {
        this.setName("oga secretary assistant");
        this.setRfc("567");
    }
}
