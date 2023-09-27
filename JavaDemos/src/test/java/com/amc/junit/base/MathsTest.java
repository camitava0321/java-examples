/**

 * 
 */
package com.amc.junit.base;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.amc.junit.base.Maths;

/**
 * @author Amitava Chakraborty
 *
 */
public class MathsTest {

	private Maths maths=null;
	public MathsTest()
	{
		maths = new Maths();
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.amc.junit.base.Maths#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		int expectedResult=40+50;
		assertEquals(expectedResult,maths.add(40, 50));
		
		//Check for a false condition
		assertFalse(maths.add(40, 49)>expectedResult);
	}

	/**
	 * Test method for {@link com.amc.junit.base.Maths#multiply(int, int)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testMultiply() {
		long expectedResult=40*50;
		long actualResult = maths.multiply(40, 50);
		assertEquals(expectedResult,actualResult);

		//Check for a true condition
		assertTrue(maths.multiply(40, 51)>expectedResult);

		
		//This test will still fail due to the following deliberate fail call.
		fail("Not yet implemented"); // TODO
	}

}