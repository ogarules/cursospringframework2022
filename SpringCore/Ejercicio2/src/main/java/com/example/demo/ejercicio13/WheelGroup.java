package com.example.demo.ejercicio13;

import java.util.List;

import lombok.Data;

@Data
public class WheelGroup {
    private List<Wheel> wheelList;

    public WheelGroup() {
    }

    public WheelGroup(List<Wheel> wheelList) {
        this.wheelList = wheelList;
    }
}
