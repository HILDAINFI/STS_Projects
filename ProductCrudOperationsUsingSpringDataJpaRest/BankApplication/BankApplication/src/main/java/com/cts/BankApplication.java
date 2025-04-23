package com.cts;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.model.Account;
import com.cts.service.AccountService;
import com.cts.service.AccountServiceImpl;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BankApplication.class, args);
		AccountService service = context.getBean("accountService", AccountServiceImpl.class);
		System.out.println("Service Obj" + service);
		int accountNo;
		String accountHolderName;
		String accountType;
		int accountBalance;
		int amount;
		Account account;
		System.out.println("***********account Management App**********");
		while (true) {
			System.out.println("1.create account");
			System.out.println("2.Update account");
			System.out.println("3.Get account details By Id");
			System.out.println("4.Deposit amount");
			System.out.println("5.Withdraw amount");
			System.out.println("6.Exit");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter account Details To Save");
				System.out.println("Enter the account number");
				accountNo = scanner.nextInt();
				System.out.println("Enter the account holder name");
				accountHolderName = scanner.next();
				System.out.println("Enter the account type");
				accountType = scanner.next();
				System.out.println("Enter the account balance");
				accountBalance = scanner.nextInt();
				account = new Account(accountNo, accountHolderName, accountType, accountBalance);
				System.out.println(service.createAccount(account));
				break;
			case 2:
				System.out.println("Enter account Details To update");
				System.out.println("Enter the account number");
				accountNo = scanner.nextInt();
				System.out.println("Enter the account holder name");
				accountHolderName = scanner.next();
				System.out.println("Enter the account type");
				accountType = scanner.next();
				System.out.println("Enter the account balance");
				accountBalance = scanner.nextInt();
				account = new Account(accountNo, accountHolderName, accountType, accountBalance);
				System.out.println(service.updateAccountDetails(account));
				break;
			case 3:
				System.out.println("Enter the existing account id");
				accountNo = scanner.nextInt();
				System.out.println(service.getAccountDetails(accountNo));
				break;
			case 4:
				System.out.println("Enter the existing account id");
				accountNo = scanner.nextInt();
				System.out.println("Enter the amount to deposit");
				amount = scanner.nextInt();
				System.out.println(service.depositAmount(accountNo, amount));
				break;
			case 5:
				System.out.println("Enter the existing account id");
				accountNo = scanner.nextInt();
				System.out.println("Enter the amount to withdraw");
				amount = scanner.nextInt();
				System.out.println(service.withdrawAmount(accountNo, amount));
				break;

			case 6:
				System.out.println("Thank You !!!!");
				System.exit(1);
				scanner.close();
				break;

			default:
				break;
			}

		}
	}
}
