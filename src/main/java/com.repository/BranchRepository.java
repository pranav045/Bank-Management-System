package com.repository;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.database.HibernateConnection;
import com.entity.Bank;
import com.entity.Branch;

public class BranchRepository {
	public static void addBranch() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Bank Id: ");
		String bank_id = sc.nextLine();
		Bank b1 = em.find(Bank.class, bank_id);
		if (b1 == null) {
			b1 = new Bank();
			System.out.print("Enter Bank name: ");
			String b_name = sc.nextLine();
			System.out.print("Enter Bank Code: ");
			String b_code = sc.nextLine();
			System.out.print("Enter Bank address: ");
			String b_address = sc.nextLine();
			b1.setId(bank_id);
			b1.setName(b_name);
			b1.setCode(b_code);
			b1.setAddress(b_address);
		}
		Branch br = new Branch();
		System.out.print("Enter Branch Id: ");
		String brid = sc.nextLine();
		System.out.print("Enter Branch name: ");
		String brname = sc.nextLine();
		System.out.print("Enter Branch Code: ");
		String brcode = sc.nextLine();
		System.out.print("Enter Branch address: ");
		String braddress = sc.nextLine();
		br.setBranch_id(brid);
		br.setAddress(braddress);
		br.setName(brname);
		br.setBank(b1);
		et.begin();
		if (em.find(Bank.class, b1.getId()) == null) {
			em.persist(b1);
		}
		em.persist(br);
		et.commit();
	}

	public void removeBranch() {
		EntityManager em = HibernateConnection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Branch Id: ");
		String id = sc.nextLine();
		Branch br1 = em.find(Branch.class, id);
		if (br1 != null) {
			et.begin();
			em.remove(br1);
			et.commit();
		} else {
			System.out.println("Branch doesn't exists");
		}
		sc.close();

	}
}
