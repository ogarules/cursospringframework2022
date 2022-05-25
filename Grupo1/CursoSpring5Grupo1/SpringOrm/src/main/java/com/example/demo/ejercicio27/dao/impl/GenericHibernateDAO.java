package com.example.demo.ejercicio27.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.example.demo.ejercicio27.dao.IGenericDAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
    
    protected @Getter final Class<T> persistentClass;
    
    @Autowired
    protected @Getter SessionFactory sessionFactory;

    public GenericHibernateDAO(Class<T> type) {
        this.persistentClass = type;
    }

    @Override
    public void insert(T entity) {
        this.sessionFactory.getCurrentSession().save(entity);
    }
    
    @Override
    public void update(T entity) {
        this.sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public T findById(ID id) {
        return sessionFactory.getCurrentSession().get(this.persistentClass, id);
    }

    @Override
    public T delete(ID id) {
        T entity = this.findById(id);
        return this.delete(entity);
    }

    @Override
    public T delete(T entity) {
        this.sessionFactory.getCurrentSession().delete(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return (List<T>)sessionFactory.getCurrentSession().createQuery("FROM " + this.persistentClass.getName())
                .list();
    }
}
