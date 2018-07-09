package com.revature.bankapp;
import java.util.HashMap;

public class AccountStorage {
	private HashMap<Integer,Account> accountMap;
	
	
	public AccountStorage() {
		accountMap = new HashMap<Integer,Account>();
		load();
	}
	
	public void load() {
		//TODO Use FileIO to load account information.
	}
	
	public void write() {
		//TODO Upon closing, write any account information.
	}
	public boolean haveAccount(int ID) {
		return accountMap.containsKey(ID);
	}
	
	public Account getAccount(int ID) {
		if (accountMap.containsKey(ID)) {
			return accountMap.get(ID);
		} else {
			return null;
		}
	}
	
	public void createAccount(int ID) {
		if (!accountMap.containsKey(ID)) {
			accountMap.put(ID, new Account(ID));
		}
	}
	
	public void removeAccount(int ID) {
		if (accountMap.containsKey(ID)) {
			accountMap.remove(ID);
		}
	}
}
