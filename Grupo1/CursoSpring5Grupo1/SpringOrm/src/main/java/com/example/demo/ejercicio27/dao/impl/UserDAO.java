package com.example.demo.ejercicio27.dao.impl;

import com.example.demo.ejercicio27.dao.IUserDAO;
import com.example.demo.ejercicio27.domain.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends GenericHibernateDAO<User, Long> implements IUserDAO {
    
    public UserDAO() {
        super(User.class);
    }
}
