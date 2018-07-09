package com.revature.bankapp;

public class BankApp 
{
    public static void main( String[] args )
    {
        System.out.println( "BankApp Loaded" );
		Runnable S = new Session();
		Thread SessionThread = new Thread(S);
		SessionThread.start();
    }
}
