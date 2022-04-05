package com.example.demo.ejercicio15.setter;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Journalist {
    private String name;
    private Integer age;
    private String rfc;
    
    private Notebook notebook;
    private Pen pen;

    @Autowired
    public void setName(String name) {
        this.name = name;
    }
    
    @Autowired
    public void setAge(Integer age) {
        this.age = age;
    }

    @Autowired
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Autowired
    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Autowired
    public void setPen(Pen pen) {
        this.pen = pen;
    }
    
    
}
