package com.example.demo.ejercicio8;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Subject subject;

    private Student() {
    }

    public static Student constructStudent(String name, String subjectName, String teacherName) {
        Student student = new Student();
        student.setName(name);
        student.setSubject(new Subject());
        student.getSubject().setName(subjectName);
        student.getSubject().setTeacher(new Teacher());
        student.getSubject().getTeacher().setName(teacherName);

        return student;
    }
}
