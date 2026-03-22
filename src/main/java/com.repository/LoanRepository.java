package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Customer;
import com.entity.Loan;

public class LoanRepository {
	public void addLoan() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter loan id: ");
		int id = sc.nextInt();
		sc.nextLine();
		Loan loan = em.find(Loan.class, id);
		if (loan == null) {
			loan = new Loan();
			loan.setLoan_id(id);
			System.out.print("Enter loan type: ");
			String type = sc.nextLine();
			System.out.print("Enter loan amount: ");
			double amount = sc.nextDouble();
			sc.nextLine();
			loan.setLoan_type(type);
			loan.setAmount(amount);
		} else {
			System.out.println("Loan id alreay exists");
		}
		et.begin();
		if (em.find(Loan.class, id) == null) {
			System.out.print("Enter customer id: ");
			int cust_id = sc.nextInt();
			sc.nextLine();

			List<Customer> customers = new ArrayList<>();
			Customer customer = em.find(Customer.class, cust_id);
			if (customer == null) {
				customer = new Customer();
				System.out.print("Enter Customer name: ");
				String name = sc.nextLine();

				System.out.print("Enter Customer Phone.No: ");
				String phone = sc.nextLine();

				System.out.print("Enter Customer address: ");
				String address = sc.nextLine();
				customer.setCustid(cust_id);
				customer.setName(name);
				customer.setPhone(phone);
				customer.setAddress(address);
			}
			customers.add(customer);
			loan.setCustomer(customers);
			em.persist(loan);

			if (em.find(Customer.class, cust_id) == null) {
				em.persist(customer);
			}
		}
		et.commit();
		sc.close();
	}
		public void removeLoan() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Loan Id: ");
		int id = sc.nextInt();
		Loan loan = em.find(Loan.class, id);
		if (loan != null) {
			et.begin();
			em.remove(loan);
			et.commit();
		} else {
			System.out.println("Loan id " + id + " not exists");
		}
		sc.close();
	}
}
