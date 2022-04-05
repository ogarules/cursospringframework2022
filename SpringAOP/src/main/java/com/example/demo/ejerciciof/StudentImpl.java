package com.example.demo.ejerciciof;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentImpl implements Student{
    private @Getter @Setter String studentName;
    private @Getter @Setter int studentNo;
    
    @Override
    public void showDetails() {
        log.info("{}", studentNo);
        log.info(studentName);
    }

    
}
