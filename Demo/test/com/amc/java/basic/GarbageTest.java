package com.amc.java.basic;

import junit.framework.TestCase;

public class GarbageTest extends TestCase {

	public GarbageTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	public final void testMain() {
		String []args={"before"};
		Garbage.main(args);
		args[0]="after";
		Garbage.main(args);
		fail("Not yet implemented"); // TODO
	}

}
