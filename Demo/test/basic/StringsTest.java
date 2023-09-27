/**
 * 
 */
package com.amc.junit.basic;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amc.junit.base.Strings;

/**
 * @author Amitava Chakraborty
 *
 */
public class StringsTest {

	String testData1=null;
	
	Strings strings=null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		strings=new Strings();
		testData1="Input_String";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.amc.junit.base.Strings#concatStrings(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConcatStrings() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReturnAString()
	{
		String expectedResult="Input_String";
		
		//Check if we are receiving a null String
		assertNull(strings.returnAString(testData1));

		//Check if we are receiving a 'not null' String
		assertNotNull(strings.returnAString(testData1));

		//Check if we are receiving the expected result
		assertEquals(expectedResult,strings.returnAString(testData1));
		
	}
	
}
