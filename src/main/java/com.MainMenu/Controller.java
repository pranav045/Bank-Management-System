package com.MainMenu;

import java.util.Scanner;

import com.repository.AccountRepository;
import com.repository.BankRepository;

public class Controller {
	public static void main(String[] args) {
		AccountRepository account = new AccountRepository();
		BankRepository Bank = new BankRepository();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Bank Management System");
		System.out.println("How may I help you?");
		System.out.println("1. Account Settings");
		System.out.println("2. Bank settings");
		System.out.print("Enter option: ");
		int option = sc.nextInt();
		switch (option) {
		case 1:
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
		}
	}
}
