package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
//
//	public abstract String createAccount(Account accountDetails);
//
//	public abstract String updateAccountDetails(Account account);
//         
//	public abstract Account getAccountDetails(int accountNo);
	
	public abstract String withdrawAmount(int accountNo,int amount);

	public abstract String depositAmount(int accountNo,int amount);

}
