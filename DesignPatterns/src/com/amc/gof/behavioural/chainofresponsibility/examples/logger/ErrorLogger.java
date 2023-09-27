/**
 * 
 */
package com.amc.gof.behavioural.chainofresponsibility.examples.logger;
/**
 * @author Amitava Chakraborty
 * Feb 4, 2002 
 * Concrete class extending AbstractLogger - logs to Error Console 
 */
public class ErrorLogger extends AbstractLogger {

	   public ErrorLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.println("Error Console::Logger: " + message);
	   }
}