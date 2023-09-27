/**
 * 
 */
package com.amc.gof.behavioural.interpreter.examples.expression;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002
 * Concrete classes implementing Expression interface. 
 */
public class AndExpression implements Expression {
	 
   private Expression expr1 = null;
   private Expression expr2 = null;

   public AndExpression(Expression expr1, Expression expr2) { 
      this.expr1 = expr1;
      this.expr2 = expr2;
   }

   @Override
   public boolean interpret(String context) {		
      return expr1.interpret(context) && expr2.interpret(context);
   }
}

