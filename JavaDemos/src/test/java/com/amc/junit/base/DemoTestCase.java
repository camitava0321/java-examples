/**
 * Demo: How to use JUnit Fixtures, setUp() and tearDown().
 * Demonstrates: 
 * 	1) setup test data in setUp()fixture
 * 	2) test method to Multiply two values 
 * 	3) clears the test data in tearDown() fixture.
 */
package com.amc.junit.base;

import junit.framework.TestCase;

/**
 * @author Amitava Chakraborty
 *
 */
public class DemoTestCase extends TestCase{
	protected int entity, multiplier;
	protected double result;
	
	//setup test data - runs before very test invocation
	//extends TestCase - hence @Before is not necessary
	protected void setUp()
	{
		entity=20;
		multiplier=3;
		result = 20*3;
	}
	
	//test method: Multiply entity with mutiplier
	public void testMultiplication()
	{
		double result1 = entity*multiplier;
		assertTrue(result1==result);
	}
	
	//Clears test data - runs aftr every test method
	protected void tearDown()
	{
		entity=0;
		multiplier=0;
		result=0;
	}

}
