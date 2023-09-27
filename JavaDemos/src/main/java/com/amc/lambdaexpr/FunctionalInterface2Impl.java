/**
 * 
 */
package com.amc.lambdaexpr;

/**
 * @author Amitava Chakraborty 2023
 *
 */
public class FunctionalInterface2Impl implements FunctionalInterface2 {

	@Override
	public void onlyOneMethod(int param1, String param2) {
		System.out.printf("Dummy Implementation {}, {}\n",param1,param2);
	}

}
