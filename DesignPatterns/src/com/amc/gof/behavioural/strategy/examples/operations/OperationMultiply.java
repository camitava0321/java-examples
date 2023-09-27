/**
 * 
 */
package com.amc.gof.behavioural.strategy.examples.operations;

/**
 * @author Amitava Chakraborty
 * Oct 12, 2002 
 * Concrete class implementing Strategy interface.
 */
public class OperationMultiply implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 * num2;
   }
}