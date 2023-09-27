/**
 * 
 */
package com.amc.gof.behavioural.chainofresponsibility.examples.logger;
/**
 * @author Amitava Chakraborty
 * Feb 4, 2002 
 * In this we shall create different types of loggers. 
 * Assign error levels and set next logger in each logger. 
 * Next logger in each logger represents the part of the chain.
 */
public class Main {
  private static AbstractLogger getChainOfLoggers(){

  AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
  AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
  AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }

   public static void main(String[] args) {
      AbstractLogger loggerChain = getChainOfLoggers();

      loggerChain.logMessage(AbstractLogger.INFO, 
         "This is an information.");

  loggerChain.logMessage(AbstractLogger.DEBUG, 
     "This is an debug level information.");

  loggerChain.logMessage(AbstractLogger.ERROR, 
     "This is an error information.");
   }
}
