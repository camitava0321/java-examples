package com.amc.junit.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Test Suite
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{MathsTest.class,StringsTest.class})
public class BasicTestSuite {
}
