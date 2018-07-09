package com.revature.bankapp;

import java.util.HashMap;

public class Login {
	private HashMap<String,Integer> loginMap;
	
	public Login() {
		loginMap = new HashMap<String,Integer>();
	}
	
	public boolean haveID(String input) {
		return loginMap.containsKey(input);
	}
	
	public int getID(String input) {
		return loginMap.get(input);
	}
	
	public void addID(String username, int accountnumber) {
		loginMap.put(username, accountnumber);
	}
	
	public void load() {
		//TODO Use FileIO to load account information.
	}
	
	public void write() {
		
	}
}
