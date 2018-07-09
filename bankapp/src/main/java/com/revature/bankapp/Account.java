package com.revature.bankapp;

public class Account {
	private int accountnumber;
	private String accountholder;
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
