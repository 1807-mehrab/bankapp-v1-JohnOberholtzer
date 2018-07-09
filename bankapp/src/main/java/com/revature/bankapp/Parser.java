package com.revature.bankapp;

import java.util.HashSet;
import java.util.Scanner;

public class Parser {
	private Scanner reader;
	private HashSet<String> validCommands;
	private HashSet<String> validCommands2;
	
	public Parser() {
		
		validCommands = new HashSet<String>();
		validCommands2 = new HashSet<String>();
		validCommands.add("Login");
		validCommands.add("Create Account");
		validCommands.add("Exit");
		validCommands2.add("Logout");
		validCommands2.add("Check Balance");
		validCommands2.add("Withdraw");
		validCommands2.add("Deposit");
		validCommands2.add("Transfer");
		reader = new Scanner(System.in);
		System.out.println("[< Welcome to BankApp");
	}
	
	public void close() {
		reader.close();

	}
	
	public boolean isCommand(String input) {
		if (validCommands.contains(input)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCommand2(String input) {
		if (validCommands2.contains(input)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidAccountNumber(String input) {
		//TODO implement account number checker
		return false;
	}
	
	public String inputAttempt() {
		String inputline ="";
		try {
			inputline = reader.nextLine();
			} catch (IllegalStateException ex) {
				ex.getMessage();
				System.out.println("[< Program Closed");
			}
		return inputline;
	}
	
	public Command parse(int input) {
		if (input == 0) {
			System.out.println("[> Type \"Login\", \"Create Account\", or \"Exit\"");
			System.out.print("[> ");
			String inputline = inputAttempt();
			//TODO implement
			if (isCommand(inputline)){
				return new Command(inputline);
			} else {
				System.out.println("[< Invalid Command");
				return new Command("");
			}
		} else if (input == 1) {
			System.out.println("[> Please enter your Username: ");
			System.out.print("[> ");
			String inputline = inputAttempt();
			return new Command(inputline);
		} else if (input == 2) {
			System.out.println("[> Type one of the following: ");
			System.out.println("[> \"Check Balance\", \"Withdraw\", \"Deposit\", or \"Logout\"");
			System.out.print("[> ");
			String inputline = inputAttempt();
			if (isCommand2(inputline)){
				return new Command(inputline);
			} else {
				System.out.println("[< Invalid Command");
				return new Command("");
			}
		} else if (input == 3) {
			System.out.println("[> Please type your password: ");
			System.out.print("[> ");
			String inputline = inputAttempt();
			return new Command(inputline);
		} else if (input == 4) {
			System.out.println("[> Please enter an amount: ");
			System.out.print("[> ");
			String inputline = inputAttempt();
			return new Command(inputline);
		} else if (input == 5) {
			System.out.println("[> Enter destination Account Number: ");
			System.out.print("[> ");
			String inputline = inputAttempt();
			return new Command(inputline);
		} else {
			return new Command("");
		}
	}
}
