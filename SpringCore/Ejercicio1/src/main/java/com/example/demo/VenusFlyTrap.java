package com.example.demo;

public class VenusFlyTrap extends Plant implements BugEater {

    @Override
    public String consume(Bug bug) {
        return "Venus Fly trap consumed bug";
    }

    @Override
    String consume(Sunlight sunlight) {
        return "Venus Fly trap consumed sunlight";
    }
    
}
