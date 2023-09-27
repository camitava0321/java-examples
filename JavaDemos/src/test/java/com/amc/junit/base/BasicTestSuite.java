package com.amc.junit.base;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Test Suite
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{MathsTest.class,com.amc.junit.base.StringsTest.class})
public class BasicTestSuite {
}
