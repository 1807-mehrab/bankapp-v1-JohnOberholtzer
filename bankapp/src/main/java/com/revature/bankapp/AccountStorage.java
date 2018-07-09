package com.revature.bankapp;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.*;

public class AccountStorage {
	private HashMap<Integer,Account> accountMap;
	
	
	public AccountStorage() {
		accountMap = new HashMap<Integer,Account>();
	}
	
	public void load(Login L) {
		LinkedList<String> fileList = new LinkedList<String>();
		File thisdirectory = new File(System.getProperty("user.dir"));
		File[] files = thisdirectory.listFiles();
		for (File f : files) {
			
			if (f.getName().endsWith(".acc")){
				System.out.println("File Located: " + f.getName());
				try {
					FileInputStream fis = new FileInputStream(f.getName());
			        ObjectInputStream in = new ObjectInputStream(fis);
			        try {
			        	Object O = in.readObject(); //Code is hitting IO exception on this line
			        	System.out.println("Object Read");
			        	Account A = (Account)O;
			        	accountMap.put(A.getID(), A);
			        	L.addID(A.getName(), A.getID());
			        } catch (ClassNotFoundException ex) {
			        	ex.getMessage();
			        	System.out.println("CLASS NOT FOUND EXCEPTION");
			        }
			        in.close();
			        fis.close();
				} catch (IOException ex) {
		        	ex.getMessage();
		        	System.out.println("IO EXCEPTION ON FILE LOAD");
		        }
			}
		}
		for (int I: accountMap.keySet()) {
			System.out.println("Account Loaded: " + I);
		}
		
		
	}
	
	public void write() {
		for (int AN : accountMap.keySet()) {
			Account A = accountMap.get(AN);
			String filename = ("Account_" + A.getID() + ".acc");
			try {
				FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(file);
				out.close();
				file.close();
			} catch (IOException ex){
				ex.getMessage();
			}
			
		}
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
