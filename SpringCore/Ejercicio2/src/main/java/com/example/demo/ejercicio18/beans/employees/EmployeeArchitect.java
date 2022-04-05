package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;
import com.example.demo.ejercicio18.beans.Employee;

@Named
@Singleton
@EmployeeQualifier(employeeType = EmployeeType.ARCHITECT)
public class EmployeeArchitect extends Employee {
    public EmployeeArchitect() {
        this.setName("oga architect");
        this.setRfc("456");
    }
}
