package com.repository;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Account;
import com.entity.Customer;

public class AccountRepository {
	EntityManager em = HibernateConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();

	public void addAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account No.: ");
		String acc_no = sc.nextLine();
		Account ac1 = em.find(Account.class, acc_no);
		et.begin();
		if (ac1 == null) {
			ac1 = new Account();
			ac1.setAccount_no(acc_no);
			System.out.print("Enter Account Type: ");
			String acc_type = sc.nextLine();
			System.out.print("Enter Account Balance: ");
			double balance = sc.nextDouble();
			ac1.setAcc_Type(acc_type);
			ac1.setBalance(balance);
			System.out.println("Enter Customer id: ");
			int cust_id = sc.nextInt();
			Customer customer = em.find(Customer.class, cust_id);
			if (customer == null) {
				customer = new Customer();
				customer.setCustid(cust_id);
				System.out.println("Enter customer name: ");
				String name = sc.nextLine();
				System.out.println("Enter customer address: ");
				String address = sc.nextLine();
				System.out.println("Enter phone no.: ");
				String phone = sc.nextLine();
				customer.setName(name);
				customer.setAddress(address);
				customer.setPhone(phone);
				ac1.setCustomer(customer);
			} else {
				ac1.setCustomer(customer);
			}
			em.persist(customer);

		} else {
			System.out.println("Account already exists");
		}
		sc.close();
		if (em.find(Account.class, acc_no) == null) {
			em.persist(ac1);
			et.commit();
		}
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
