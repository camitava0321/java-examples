/**
 * 
 */
package com.amc.gof.behavioural.command.examples.stock;
/**
 * @author Amitava Chakraborty
 * Mar 13, 2002 
 * Implements Command Interface 
 */
public class SellStock implements Order {
	   private Stock abcStock;

	   public SellStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.sell();
	   }
}