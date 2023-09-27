/**
 * 
 */
package com.amc.gof.behavioural.command.examples.stock;
/**
 * @author Amitava Chakraborty
 * Mar 13, 2002 
 * Request that encapsulates a Command
 */
public class Stock {
	
	   private String name = "ABC";
	   private int quantity = 10;

	   public void buy(){
	      System.out.println("Stock [ Name: "+name+
	    		  ",Quantity: " + quantity +" ] bought");
	   }
	   public void sell(){
	      System.out.println("Stock [ Name: "+name+
	    		  ",Quantity: " + quantity +" ] sold");
	   }
}