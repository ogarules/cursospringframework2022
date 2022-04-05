package com.example.demo.ejercicio8;

public class StudentFactory {

    public Student getStudent(String name, String subjectName, String teacherName) {
        return Student.constructStudent(name, subjectName, teacherName);
    }
    
}
