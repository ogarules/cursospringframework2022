package com.example.demo.ejercicio18.beans.employees;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;
import com.example.demo.ejercicio18.beans.Employee;

@Named
@Singleton
@EmployeeQualifier(employeeType = EmployeeType.PROGRAMMER)
public class EmployeeProgrammer extends Employee {
    public EmployeeProgrammer() {
        this.setName("oga programmer");
        this.setRfc("234");
    }
}
