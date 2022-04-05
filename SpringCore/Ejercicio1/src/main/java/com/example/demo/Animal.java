package com.example.demo;

public abstract class Animal implements LivingBeing {

    abstract String walk(); 

    @Override
    public String consume(Water water) {
        return "Animal consuming water";
    }

    @Override
    public String grow() {
        return "Animal growing";
    }
    
}
