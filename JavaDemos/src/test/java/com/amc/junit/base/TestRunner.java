/**
 * 
 */
package com.amc.junit.base;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * @author Amitava Chakraborty
 *
 */
public class TestRunner {

	public static void main(String[] args) {
		
		//This way one can run a particular TestCase
		Result result = JUnitCore.runClasses(TestJUnit.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		
		//This way one can run a particular TestSuite as well
		result = JUnitCore.runClasses(BasicTestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		
	}
}
