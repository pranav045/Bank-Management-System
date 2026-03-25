package com.MainMenu;

import java.util.Scanner;

import com.repository.AccountRepository;
import com.repository.BankRepository;
import com.repository.BranchRepository;
import com.repository.CustomerRepository;
import com.repository.LoanRepository;

public class Controller {
	public static void main(String[] args) {
		AccountRepository account = new AccountRepository();
		BankRepository Bank = new BankRepository();
		BranchRepository Branch = new BranchRepository();
		CustomerRepository Customer = new CustomerRepository();
		LoanRepository loan = new LoanRepository();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Bank Management System");
		System.out.println("How may I help you?");
		System.out.println("1. Account Settings");
		System.out.println("2. Bank settings");
		System.out.println("3. Branch settings");
		System.out.println("4. Customer settings");
		System.out.println("5. Loan settings");
		System.out.print("Enter option: ");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("1. Add Account");
			System.out.println("2. Remove Account");
			System.out.print("Enter option: ");
			int option2 = sc.nextInt();
			switch (option2) {
			case 1:
				account.addAccount();
				break;
			case 2:
				account.removeAccount();
				break;
			}
			break;
		case 2:
			System.out.println("1. Add Bank");
			System.out.println("2. Remove Bank");
			System.out.print("Enter option: ");
			int option3 = sc.nextInt();
			switch (option3) {
			case 1:
				Bank.addBank();
				break;
			case 2:
				Bank.removeBank();
				break;
			}
			break;
		case 3:
			System.out.println("1. Add Branch");
			System.out.println("2. Remove Branch");
			System.out.print("Enter option: ");
			int option4 = sc.nextInt();
			switch (option4) {
			case 1:
				Branch.addBranch();
				break;
			case 2:
				Branch.removeBranch();
				break;
			}
			break;
		case 4:
			System.out.println("1. Add Customer");
			System.out.println("2. Remove Customer");
			System.out.println("3. Show accounts");
			System.out.print("Enter option: ");
			int option5 = sc.nextInt();
			switch (option5) {
			case 1:
				Customer.addCustomer();
				break;
			case 2:
				Customer.removeCustomer();
				break;
			case 3:
				Customer.allAccounts();
				break;
			}
			break;
		case 5:
			System.out.println("1. Add Loan");
			System.out.println("2. Remove Loan");
			System.out.print("Enter option: ");
			int option6 = sc.nextInt();
			switch (option6) {
			case 1:
				loan.addLoan();
				break;
			case 2:
				loan.removeLoan();
				break;
			}
			break;
		}

		sc.close();
	}
}
