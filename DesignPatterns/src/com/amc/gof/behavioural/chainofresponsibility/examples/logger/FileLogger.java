/**
 * 
 */
package com.amc.gof.behavioural.chainofresponsibility.examples.logger;
/**
 * @author Amitava Chakraborty
 * Feb 4, 2002 
 * Concrete class extending AbstractLogger - logs to File
 */
public class FileLogger extends AbstractLogger {

	   public FileLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {		
	      System.out.println("File::Logger: " + message);
	   }
}