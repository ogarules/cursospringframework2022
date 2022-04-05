package com.example.demo.ejercicio17.impl;

import com.example.demo.ejercicio17.IRepositoryClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class RepositoryClass implements IRepositoryClass {
    @Autowired
    private String repositoryClassName;
}
