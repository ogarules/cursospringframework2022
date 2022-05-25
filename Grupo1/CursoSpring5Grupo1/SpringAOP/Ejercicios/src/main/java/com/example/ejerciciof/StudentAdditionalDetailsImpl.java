package com.example.ejerciciof;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentAdditionalDetailsImpl implements StudentAdditionalDetails {
    private @Getter @Setter String city;
    private @Getter @Setter String country;
    
    @Override
    public void showAdditionalDetails() {
        log.info(this.city);
        log.info(this.country);
    }
    
}
