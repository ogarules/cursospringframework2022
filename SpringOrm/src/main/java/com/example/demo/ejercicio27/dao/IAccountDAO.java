package com.example.demo.ejercicio27.dao;

import java.util.List;

import com.example.demo.ejercicio27.domain.Account;

public interface IAccountDAO extends IGenericDAO<Account,Long> {
    List<Account> findByCustomerId(Long id);
}
