package com.example.demo.ejerciciof;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentAdditionalDetailsImpl implements StudentAdditionalDetails {
    private @Getter @Setter String city;
    private @Getter @Setter String country;
    
    @Override
    public void ShowAdditionalDetails() {
        log.info(city);
        log.info(country);
    }    
}
