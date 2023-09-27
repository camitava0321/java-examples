/**
 * 
 */
package com.amc.gof.behavioural.interpreter.examples.expression;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002
 * Concrete classes implementing Expression interface. 
 */
public class TerminalExpression implements Expression {
	
   private String data;

   public TerminalExpression(String data){
      this.data = data; 
   }

   @Override
   public boolean interpret(String context) {
      if(context.contains(data)){
         return true;
      }
      return false;
   }
}
