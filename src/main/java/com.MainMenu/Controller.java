package com.MainMenu;

import java.util.Scanner;

import com.repository.AccountRepository;

public class Controller {
	public static void main(String[] args) {
		AccountRepository repo = new AccountRepository();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter option: ");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			repo.addAccount();
			break;
		case 2:
			repo.removeAccount();
			break;
		}
		;
		System.out.println("1. Add Account");
		System.out.println("2. Remove Account");
	}
}
