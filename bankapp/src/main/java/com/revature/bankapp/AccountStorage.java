package com.revature.bankapp;
import java.util.HashMap;

public class AccountStorage {
	private HashMap<Integer,Account> accountMap;
	
	
	public AccountStorage() {
		accountMap = new HashMap<Integer,Account>();
		
		//TODO Load account data from File I/O
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
