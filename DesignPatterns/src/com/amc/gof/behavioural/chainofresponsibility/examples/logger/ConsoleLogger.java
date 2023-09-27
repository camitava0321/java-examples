/**
 * 
 */
package com.amc.gof.behavioural.chainofresponsibility.examples.logger;

/**
 * @author Amitava Chakraborty
 * Feb 4, 2002 
 * Concrete class extending the AbstractLogger - writes to console 
 */
public class ConsoleLogger extends AbstractLogger {

	   public ConsoleLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.println("Standard Console::Logger: " + message);
	   }
}