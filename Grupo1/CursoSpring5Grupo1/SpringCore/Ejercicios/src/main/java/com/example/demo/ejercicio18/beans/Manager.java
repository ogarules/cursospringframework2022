package com.example.demo.ejercicio18.beans;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.example.demo.ejercicio18.ManagerEmployeeQualifier;

import lombok.Data;

@Data
@Named
@Singleton
public class Manager {
    
    @Inject
    @ManagerEmployeeQualifier
    private Employee employee;

    @Resource(name = "teamx")
    private Team team1;

    @Resource(name = "teamy")
    private Team team2;
}
