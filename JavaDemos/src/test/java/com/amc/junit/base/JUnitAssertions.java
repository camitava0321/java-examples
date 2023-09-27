/**
 * This class shows the power of all sorts of assertions available in JUnit
 * 
 */
package com.amc.junit.base;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Amitava Chakraborty
 * But we will focus on mainly three types of assertions, viz.,
 * assertSame
 * assertNotSame
 * assertArrayEquals
 * rest are well used by anyone anyway.
 */
public class JUnitAssertions {
	private String testString1=null;
	private String testString2=null;
	private String testString3=null;
	private String testString4=null;
	
	private String[] expectedArray = {"string1", "string2", "string3"};
	private String[] actualArray = {"string1", "string2", "string3"};

	//The class is not a subclass of TestCase. Hence @Before annotation is needed
	//in order to setup the test data
	@Before
	public void setUp()
	{
		//setup test data
		testString1="Amitava";
		testString2="Amitava";
		testString3=new String("Amitava");
		testString4=new String("Amitava");
	}
	
	@Test
	public void testJUnitAssertions()
	{
		//Checks if two object references points to the same object
		//Will succeed as the two strings are initialized;
		assertSame(testString1,testString2);
		//assertSame Will fail as the two strings are instantiated;
		assertNotSame(testString3,testString4);
		assertSame(testString3,testString4);

		//Check whether two arrays are equal to each other
		org.junit.Assert.assertArrayEquals(expectedArray, actualArray);
}
}