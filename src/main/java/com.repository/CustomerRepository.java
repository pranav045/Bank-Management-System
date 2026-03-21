package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Account;
import com.entity.Customer;

public class CustomerRepository {

	public void addCustomer() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Customer Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		Customer existingCustomer = em.find(Customer.class, id);
		if (existingCustomer != null) {
			System.out.println("Customer with ID " + id + " already exists!");
			return;
		}

		System.out.print("Enter Customer name: ");
		String name = sc.nextLine();

		System.out.print("Enter Customer Phone.No: ");
		String phone = sc.nextLine();

		System.out.print("Enter Customer address: ");
		String address = sc.nextLine();

		System.out.print("Enter Customer acc.No: ");
		String accNo = sc.nextLine();

		Customer c1 = new Customer();
		c1.setCustid(id);
		c1.setName(name);
		c1.setPhone(phone);
		c1.setAddress(address);

		List<Account> accList = new ArrayList<>();
		Account account = em.find(Account.class, accNo);

		if (account == null) {
			account = new Account();
			System.out.print("Enter Account type: ");
			String accType = sc.nextLine();
			System.out.print("Enter Account Balance: ");
			double accBalance = sc.nextDouble();

			account.setAccount_no(accNo);
			account.setAcc_Type(accType);
			account.setBalance(accBalance);
		}

		accList.add(account);
		c1.setAccount(accList);

		et.begin();
		if (em.find(Account.class, account.getAccount_no()) == null) {
			em.persist(account);
		}
		em.persist(c1);
		et.commit();
	}

	public void removeCustomer() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Customer Id: ");
		int id = sc.nextInt();

		Customer c1 = em.find(Customer.class, id);
		if (c1 != null) {
			et.begin();
			em.remove(c1);
			et.commit();
		} else {
			System.out.println("Customer doesn't exist");
		}
	}
}
