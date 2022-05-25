package com.example.ejercicio24.web;

import java.util.List;

import com.example.ejercicio24.model.Account;
import com.example.ejercicio24.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccountWebView implements IAccountWebView {

	@Autowired
	private IAccountService accountService;

	@Override
	public void showAccountsFromCustomerId(Long customerId) {
		log.info(
				"Inside accountWebView.showAccountsFromCustomerId(). Showing accounts for customer: {}",
				customerId);

		List<Account> accountList = accountService
				.findCustomerAccounts(customerId);

		accountList.stream().forEach(System.out::println);
	}

	@Override
	public void processFormUpdateBalance(Account account, Long amount) {
		log.info(
				"Inside accountWebView.processFormUpdateBalance(). Account: {}, ammount: {}",
				account.getAccountNumber(),
				amount);

		accountService.updateAccountBalance(account, amount);
	}

	@Override
	public void processFormUpdateDescription(Account account) {
		log.info(
				"Inside accountWebView.processFormUpdateDescription(). Updating account [{}] description to: {}",
				account.getAccountNumber(), account.getAccountDescription());

		accountService.updateAccountDescription(account);
	}

}
