package com.revature.bankapp;
import java.io.*;

public class Account implements Serializable {
	private static final long serialVersionUID = 1234L;
	private int accountnumber;
	private String accountholder;
	private String password;
	private long currency;
	
	public Account(int accountnumber) {
		this.accountnumber = accountnumber;
		accountholder = "";
		currency = 0L;
	}
	
	public void loadData() {
		//TODO reads file data
	}
	
	public String getName() {
		return accountholder;
	}
	
	public void setName(String input) {
		accountholder = input;
	}
	
	public void setPass(String input) {
		password = input;
	}
	
	public String getPass() {
		return password;
	}
	
	public int getID() {
		return accountnumber;
	}
	
	public long getCurrency() {
		return currency;
	}
	
	public void addCurrency(long value) {
		currency += value;

	}
	
	public void remCurrency(long value) {
		currency -= value;
	}
	
}
