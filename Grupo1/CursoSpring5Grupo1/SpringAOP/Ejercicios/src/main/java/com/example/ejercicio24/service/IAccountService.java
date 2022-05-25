package com.example.ejercicio24.service;

import java.util.List;

import com.example.ejercicio24.model.Account;

public interface IAccountService {

	void updateAccountBalance(Account account, Long amount);

	List<Account> findCustomerAccounts(Long customerId);

	void updateAccountDescription(Account account);

}
