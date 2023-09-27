/**
 * 
 */
package com.amc.junit.basic;
import org.junit.*;
import static org.junit.Assert.assertEquals;;
/**
 * @author Amitava Chakraborty
 *
 */
public class TestJUnit {

	
	@Test
	public void testAdd()
	{
	String str="JUnit is working fine";
	assertEquals("JUnit is working fine", str);
	}
}
