package com.example.demo;

public class VenusFlyTrap extends Plant implements BugEater {

    @Override
    public String consume(Bug bug) {
        return "VenusFlyTrap consumed bug";
    }

    @Override
    String consume(Sunlight sunlight) {
        return "VenusFlyTrap consumed sunlight";
    }
    
}
