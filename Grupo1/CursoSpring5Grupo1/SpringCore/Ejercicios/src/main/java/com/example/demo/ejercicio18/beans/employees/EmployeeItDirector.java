package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.beans.Employee;

@Named("itDirectorEmployee")
public class EmployeeItDirector extends Employee {
    
    public EmployeeItDirector() {
        this.setName("oga");
        this.setRfc("98765");
    }
}
