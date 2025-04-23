package com.cts.service;

import com.cts.model.Account;

public interface AccountService {

	public abstract String createAccount(Account accountDetails);

	public abstract String updateAccountDetails(Account account);
         
	public abstract Account getAccountDetails(int accountNo);
	
	public abstract String withdrawAmount(int accountNo,int amount);

	public abstract String depositAmount(int accountNo,int amount);

}
