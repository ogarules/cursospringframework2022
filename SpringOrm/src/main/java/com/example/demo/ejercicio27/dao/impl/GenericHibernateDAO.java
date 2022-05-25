package com.example.demo.ejercicio27.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.example.demo.ejercicio27.dao.IGenericDAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

    protected final Class<T> persistenClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericHibernateDAO(Class<T> type) {
        this.persistenClass = type;
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
        return this.sessionFactory.getCurrentSession().get(this.persistenClass, id);
    }

    @Override
    public T delete(T entity) {

        this.sessionFactory.getCurrentSession().delete(entity);

        return entity;
    }

    @Override
    public T delete(ID id) {
        T entity = this.findById(id);
        return this.delete(entity);
    }

    @Override
    public List<T> findAll() {
        return (List<T>)this.sessionFactory.getCurrentSession()
                   .createQuery("FROM " + this.persistenClass.getName())
                .list();
    }
    
    
}
