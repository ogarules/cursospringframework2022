package com.example.demo.ejercicio25.dao;

import java.util.List;

import com.example.demo.ejercicio25.domain.Account;

public interface IAccountDAO extends IGenericDAO<Account, Long> {
    List<Account> findByCustomerId(Long id);
}
