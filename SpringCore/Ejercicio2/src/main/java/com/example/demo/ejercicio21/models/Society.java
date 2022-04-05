package com.example.demo.ejercicio21.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Society {
    private String name;

    private static String Advisors = "advisors";
    private static String President = "president";

    private List<Inventor> members = new ArrayList<>();
    private Map<String, Object> officers = new HashMap<>();

    public boolean isMember(String member) {
        var inventor =  getMember(member);
        return inventor != null ? true : false; 
    }

    public Inventor getMember(String member) {
        for (Inventor inv : members) {
            if (inv.getName().equals(member)) {
                return inv;
            }
        }

        return null;
    }
}
