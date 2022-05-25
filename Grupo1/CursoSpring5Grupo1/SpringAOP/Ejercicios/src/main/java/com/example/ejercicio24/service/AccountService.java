package com.example.ejercicio24.service;

import java.util.List;

import com.example.ejercicio24.dao.IAccountDAO;
import com.example.ejercicio24.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDAO accountDAO;

	@Override
	public void updateAccountBalance(Account account, Long amount) {
		log.info(
				"Inside accountService.updateAccountBalance(). Account: {}, ammount: {}",
				account.getAccountNumber(),
				amount);

		accountDAO.updateBalance(account, amount);
	}

	@Override
	public List<Account> findCustomerAccounts(Long customerId) {
		log.info(
				"Inside accountService.findCustomerAccounts(). Finding accounts for customer: {}",
				customerId);

		return accountDAO.findByCustomerId(customerId);
	}

	@Override
	public void updateAccountDescription(Account account) {
		log.info(
				"Inside accountService.updateAccountDescription(). Updating account [{}] description to: {}",
				account.getAccountNumber(), account.getAccountDescription());

		accountDAO.updateDescription(account);
	}

}
