/**
 * 
 */
package com.amc.junit.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Amitava Chakraborty 2023
 *
 */
public class StringsTest {

	String testData1=null;
	
	Strings strings=null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Nothing is happening during setup Before Class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Nothing is happening during teardown After Class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		strings=new Strings();
		testData1="Input_String";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Nothing is happening during teardown");
	}

	@Test
	void test() {
		fail("Not yet implemented");
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
