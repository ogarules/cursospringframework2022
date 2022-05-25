package com.example.demo.ejercicio27.dao.impl;

import com.example.demo.ejercicio27.dao.ICustomerDAO;
import com.example.demo.ejercicio27.domain.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO extends GenericHibernateDAO<Customer, Long> implements ICustomerDAO {
    public CustomerDAO() {
        super(Customer.class);
    }
}
