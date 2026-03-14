package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Account {
	@Id
	private String account_no;
	private String acc_Type;
	private double balance;
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "account_no"), inverseJoinColumns = @JoinColumn(name = "cust_id"))
	private List<Customer> customer;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAcc_Type() {
		return acc_Type;
	}

	public void setAcc_Type(String acc_Type) {
		this.acc_Type = acc_Type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
