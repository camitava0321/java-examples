package com.amc.test.suite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.amc.test.suite");
		//$JUnit-BEGIN$
		suite.addTestSuite(com.amc.datatype.BinaryTest.class);
		//$JUnit-END$
		return suite;
	}

}
