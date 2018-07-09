package com.revature.bankapp;

import java.util.HashSet;
import java.util.Scanner;

public class Parser {
	private Scanner reader;
	private HashSet<String> validCommands;

	public Parser() {
		validCommands = new HashSet<String>();
		validCommands.add("Login");
		validCommands.add("Create Account");
		validCommands.add("Exit");
		reader = new Scanner(System.in);
	}
	
	public boolean isCommand(String input) {
		if (validCommands.contains(input)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidAccountNumber(String input) {
		//TODO implement account number checker
		return false;
	}
}
