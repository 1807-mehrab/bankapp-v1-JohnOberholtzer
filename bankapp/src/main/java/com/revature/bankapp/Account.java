package com.revature.bankapp;
import java.io.*;

public class Account implements Serializable {
	private static final long serialversionUID = 123456789L;
	private int accountnumber;
	private String accountholder;
	private String password;
	private long currency;
	private boolean isAvailable;
	
	public Account(int accountnumber) {
		this.accountnumber = accountnumber;
		accountholder = "";
		currency = 0L;
		isAvailable = true;
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
	
	public synchronized long getCurrency() {
		while(!isAvailable) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}
		notifyAll();
		return currency;
	}
	
	public synchronized void addCurrency(long value) {
		while(isAvailable) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}
		
		isAvailable = true;
		currency += value;
		notifyAll();
	}
	
	public synchronized void remCurrency(long value) {
		while(isAvailable) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}
		
		isAvailable = true;
		currency -= value;
		notifyAll();
	}
	
}
