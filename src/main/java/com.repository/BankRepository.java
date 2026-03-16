package com.repository;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Bank;

public class BankRepository {
	public void addBank() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Bank Id: ");
		String id = sc.nextLine();
		System.out.print("Enter Bank name: ");
		String name = sc.nextLine();
		System.out.print("Enter Bank Code: ");
		String code = sc.nextLine();
		System.out.print("Enter Bank address: ");
		String address = sc.nextLine();
		Bank b1 = new Bank();
		b1.setId(id);
		b1.setName(name);
		b1.setCode(code);
		b1.setAddress(address);
		sc.close();
		et.begin();
		em.persist(b1);
		et.commit();
	}

}

