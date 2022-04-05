package com.example.demo;

public abstract class Plant implements LivingBeing {

    abstract String consume(Sunlight sunlight);
    
    @Override
    public String grow() {
        return "Plant growing";
    }

    @Override
    public String consume(Water water) {
        return "Plant consuming water";
    }
    
}
