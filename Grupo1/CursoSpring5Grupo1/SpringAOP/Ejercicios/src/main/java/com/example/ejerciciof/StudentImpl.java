package com.example.ejerciciof;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentImpl implements Student {
    private @Getter @Setter int studentNo;
    private @Getter @Setter String studentName;

    @Override
    public void showDetails() {
        log.info("{}", studentNo);
        log.info(studentName);
    }   

}
