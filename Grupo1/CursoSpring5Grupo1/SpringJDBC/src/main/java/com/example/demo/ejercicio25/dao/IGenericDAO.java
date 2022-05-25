package com.example.demo.ejercicio25.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {
    void insert(T entity);

    void update(T entity);

    T findById(ID id);

    T delete(ID id);

    T delete(T entity);
    
    List<T> findAll();
}
