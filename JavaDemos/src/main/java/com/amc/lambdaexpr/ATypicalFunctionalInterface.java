/**
 * 
 */
package com.amc.lambdaexpr;

/**
 * This is how a typical functional interface looks like
 * A Functional Interface always has only ONE method
 * @author Amitava Chakraborty 2023
 *
 */
@FunctionalInterface
public interface ATypicalFunctionalInterface {
	
	public void onlyOneMethod();
	//public void anotherMethodWillGiveCompilationError();
}
