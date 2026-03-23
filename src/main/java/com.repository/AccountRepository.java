package com.repository;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Account;

public class AccountRepository {
	EntityManager em = HibernateConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();

	public void addAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account No.: ");
		String acc_no = sc.nextLine();
		Account ac1 = em.find(Account.class, acc_no);
		if (ac1 == null) {
			ac1 = new Account();
			ac1.setAccount_no(acc_no);
			System.out.print("Enter Account Type: ");
			String acc_type = sc.nextLine();
			System.out.print("Enter Account Balance: ");
			double balance = sc.nextDouble();
			ac1.setAcc_Type(acc_type);
			ac1.setBalance(balance);
		} else {
			System.out.println("Account already exists");
		}
		sc.close();
		et.begin();
		if (em.find(Account.class, acc_no) == null) {
			em.persist(ac1);
		}
		et.commit();
		sc.close();
	}

	public void removeAccount() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account No.: ");
		String acc_no = sc.nextLine();
		sc.nextLine();
		Account ac1 = em.find(Account.class, acc_no);
		if (ac1 != null) {
			et.begin();
			em.remove(ac1);
			et.commit();
		} else {
			System.out.println("Account doesn't exists");
		}
		sc.close();
	}
}
