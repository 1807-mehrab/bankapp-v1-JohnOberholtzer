package com.revature.bankapp;
import java.util.Random;

public class Interpreter {
	private AccountStorage AS;
	private Parser P;
	private Boolean Active;
	private Login L;
	private int loginattempts;
	private boolean loggedin;

	public Interpreter(AccountStorage AS) {
		this.AS = AS;
		Active = true;
		P = new Parser();
		L = new Login();
		loginattempts = 0;
		loggedin = false;
	}
	
	public boolean isActive() {
		return Active;
	}
	
	public void interpret() {
		Command command =new Command("");
		if (!loggedin) {
			command = P.parse(0);
		} else {
			command = P.parse(2);
		}
		if (command.toString().equals("Exit")) {
			P.close();
			AS.write();
			System.out.println("[< Thank you for using BankApp.");
			Active = false;
		} else if(command.toString().equals("Login")) {
			command = P.parse(1);
			if (L.haveID(command.toString())){
				String username = command.toString();
				command = P.parse(3);
				int AN = L.getID(username);
				Account A = AS.getAccount(AN);
				if(command.toString().equals(A.getPass())) {
					System.out.println("[< Login Success.");
					loggedin = true;
				} else {
					loginattempts +=1;
				}
			}
		} else if(command.toString().equals("Create Account")){
			command = P.parse(1);
			if (L.haveID(command.toString())){
				System.out.println("[< That account username already exists.");
			} else {
				String username = command.toString();
				Random rand = new Random();
				int AN = rand.nextInt(999999);
				while (AS.haveAccount(AN)) {
					AN = rand.nextInt(999999);
				}
				L.addID(username, AN);
				AS.createAccount(AN);
				Account A = AS.getAccount(AN);
				A.setName(username);
				command = P.parse(3);
				A.setPass(command.toString());
				System.out.println("[< Account created. You may log in with this account.");
				System.out.println("[< Your Account Number is: "+AN);
			}
		}
	}
	
}
