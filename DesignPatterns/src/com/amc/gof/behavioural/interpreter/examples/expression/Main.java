/**
 * 
 */
package com.amc.gof.behavioural.interpreter.examples.expression;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 * Uses Expression class to create rules and then parse them
 */
public class Main {
	   //Rule: Robert and John are male
	   public static Expression getMaleExpression(){
	      Expression robert = new TerminalExpression("Robert");
	      Expression john = new TerminalExpression("John");
	      return new OrExpression(robert, john);		
	   }

	   //Rule: Julie is a married women
	   public static Expression getMarriedWomanExpression(){
	      Expression julie = new TerminalExpression("Julie");
	      Expression married = new TerminalExpression("Married");
	      return new AndExpression(julie, married);		
	   }

	   public static void main(String[] args) {
	      Expression isMale = getMaleExpression();
	      Expression isMarriedWoman = getMarriedWomanExpression();

	      System.out.println("John is male? " + isMale.interpret("John"));
	      System.out.println("Julie is a married women? " 
	      + isMarriedWoman.interpret("Married Julie"));
	   }

}
