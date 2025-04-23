package com.cts.repository;

import org.springframework.stereotype.Repository;


import com.cts.model.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String createAccount(Account account) {
		entityManager.persist(account);
		return "Account Details saved successfully";
	}

	@Override
	public String updateAccountDetails(Account account) {
		entityManager.merge(account);
		return "product updated successfully";
	}

	@Override
	public Account getAccountDetails(int accountNo) {
		return entityManager.find(Account.class, accountNo);
	}

	@Override
	public String withdrawAmount(int accountNo, int amount) {
		Account account = entityManager.find(Account.class, accountNo);
		int balance = account.getAccountBalance();
		if (balance > amount) {
			balance -= amount;
			account.setAccountBalance(balance);
			entityManager.merge(account);
			return "amount withdraw successfully";
		} else {
			return "Insufficient balance";
		}

	}

	@Override
	public String depositAmount(int accountNo, int amount) {
		Account account = entityManager.find(Account.class, accountNo);
		int balance = account.getAccountBalance() + amount;
		account.setAccountBalance(balance);
		entityManager.merge(account);
		return "amount deposited successfully";
	}

}
