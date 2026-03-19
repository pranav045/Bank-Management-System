package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Bank;
import com.entity.Branch;

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
		Branch br = new Branch();
		System.out.print("Enter Branch Id: ");
		String brid = sc.nextLine();
		System.out.print("Enter Branch name: ");
		String brname = sc.nextLine();
		System.out.print("Enter Branch Code: ");
		String brcode = sc.nextLine();
		System.out.print("Enter Branch address: ");
		String braddress = sc.nextLine();
		List<Branch> branches = new ArrayList<>();
		br.setBranch_id(brid);
		br.setAddress(braddress);
		br.setName(brname);
		b1.setId(id);
		b1.setName(name);
		b1.setCode(code);
		b1.setAddress(address);
		branches.add(br);
		b1.setBranch(branches);
		sc.close();
		et.begin();
		em.persist(b1);
		et.commit();
	}

	public void removeBank() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Bank Id: ");
		String id = sc.nextLine();
		Bank b1 = em.find(Bank.class, id);
		if (b1 != null) {
			et.begin();
			em.remove(b1);
			et.commit();
		} else {
			System.out.println("Bank doesn't exists");
		}
		sc.close();

	}
//	}
}
