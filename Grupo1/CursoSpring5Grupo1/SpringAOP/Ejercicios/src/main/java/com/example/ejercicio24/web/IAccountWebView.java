package com.example.ejercicio24.web;

import com.example.ejercicio24.model.Account;

public interface IAccountWebView {

	void showAccountsFromCustomerId(Long customerId);

	void processFormUpdateBalance(Account account, Long amount);

	void processFormUpdateDescription(Account account);

}
