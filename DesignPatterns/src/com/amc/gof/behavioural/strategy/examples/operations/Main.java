/**
 * 
 */
package com.amc.gof.behavioural.strategy.examples.operations;

/**
 * @author Amitava Chakraborty
 * Oct 12, 2002 
 * Use the Context to see change in behaviour when it changes its Strategy.
 */
public class Main {
	   public static void main(String[] args) {
		      Context context = new Context(new OperationAdd());		
		      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		      context = new Context(new OperationSubstract());		
		      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		      context = new Context(new OperationMultiply());		
		      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
		   }
}