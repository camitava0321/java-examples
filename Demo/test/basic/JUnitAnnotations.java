/**
 * This is to demonstrate the power of JUnit Annotations.
 * 
 */
package com.amc.junit.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Amitava Chakraborty
 *
 */
public class JUnitAnnotations {

	@BeforeClass
	public static void executeBeforeAnyTestMethods()
	{
		System.out.println("Execution Id: 1 - Ran before any of the test methods\n");
	}
	
	@Before
	public void executeBeforeATestMethod()
	{
		System.out.println("Execution Id: 2 - Ran before the test method");
	}
	
	@Test
	public void testMethod1()
	{
		System.out.println("Execution Id: 3 - Ran the test method - 1");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("Execution Id: 4 - Ran the test method - 2");
	}
	
	@Test
	@Ignore
	public void testMethod3()
	{
		System.out.println("Execution Id: 5 - Ran the test method - 3");
	}
	
	@After
	public void executeAfterATestMethod()
	{
		System.out.println("Execution Id: 6 - Ran after the test method\n");
	}
	
	@AfterClass
	public static void executeAfterAllTestMethods()
	{
		System.out.println("Execution Id: 10 - Ran all the test methods finished");
	}
}
