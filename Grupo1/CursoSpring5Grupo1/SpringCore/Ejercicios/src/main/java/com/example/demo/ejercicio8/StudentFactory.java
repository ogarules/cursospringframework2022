package com.example.demo.ejercicio8;

public class StudentFactory {

    public Student getStudent(String name, String subject, String teacherName) {
        
        return Student.constructStudent(name, subject, teacherName);
    }
    
}
