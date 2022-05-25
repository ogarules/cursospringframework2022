package com.example.ejercicio24.dao;

import java.util.List;

import com.example.ejercicio24.model.Account;

public interface IAccountDAO {

	List<Account> findByCustomerId(Long customerId);

	void updateBalance(Account account, Long amount);

	void updateDescription(Account account);

}
