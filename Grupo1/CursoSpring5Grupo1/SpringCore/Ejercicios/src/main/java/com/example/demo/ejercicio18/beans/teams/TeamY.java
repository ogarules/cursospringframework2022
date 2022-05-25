package com.example.demo.ejercicio18.beans.teams;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.EmployeeQualifier;
import com.example.demo.ejercicio18.EmployeeQualifier.EmployeeType;
import com.example.demo.ejercicio18.beans.Employee;
import com.example.demo.ejercicio18.beans.Team;

@Named("teamy")
@Singleton
public class TeamY extends Team {
    
    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.ARCHITECT)
    public void setArchitect(Employee architect) {
        super.setArchitect(architect);
    }

    @Override
    @Resource(name="teamyEmployees")
    public void setEmployees(List<String> employees) {
        super.setEmployees(employees);
    }

    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.PROGRAMMER)
    public void setProgrammer(Employee programmer) {
        super.setProgrammer(programmer);
    }

    @Override
    @Inject
    @EmployeeQualifier(employeeType = EmployeeType.TESTER)
    public void setTester(Employee tester) {
        // TODO Auto-generated method stub
        super.setTester(tester);
    }
}
