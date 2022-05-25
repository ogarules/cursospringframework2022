package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;

import com.example.demo.ejercicio18.beans.Employee;

@Named("generalDirectorEmployee")
public class EmployeeGeneralDirector extends Employee {
    public EmployeeGeneralDirector() {
        this.setName("oga 2");
        this.setRfc("sfdfgsdfg");
    }
}
