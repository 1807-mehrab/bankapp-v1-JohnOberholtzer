package com.revature.bankapp;

class Session implements Runnable {
	AccountStorage AS;
	Interpreter Interpret;
	public void run() {
		AS = new AccountStorage();
		Interpret = new Interpreter(AS);
		while (Interpret.isActive()) {
			Interpret.interpret();
		}
	}
}