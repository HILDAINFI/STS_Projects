package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.cts.model.Account;
import com.cts.repository.AccountRepository;
import com.cts.repository.AccountRepositoryImpl;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repository;

	public AccountServiceImpl() {
		repository = new AccountRepositoryImpl();

	}

	@Override
	public String createAccount(Account accountDetails) {
		return repository.createAccount(accountDetails);
	}

	@Override
	public String updateAccountDetails(Account account) {
		return repository.updateAccountDetails(account);
	}

	@Override
	public Account getAccountDetails(int accountNo) {
		return repository.getAccountDetails(accountNo);
	}

	@Override
	public String withdrawAmount(int accountNo, int amount) {
		return repository.withdrawAmount(accountNo, amount);
	}

	@Override
	public String depositAmount(int accountNo, int amount) {
		return repository.depositAmount(accountNo, amount);
	}

}
