package com.revature.bankapp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Evaluator extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    
	public static final AccountStorage AS = new AccountStorage();
	
	
	
	public Evaluator( String testName )
    {
        super( testName );
        
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Evaluator.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
