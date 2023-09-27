/**
 * 
 */
package com.amc.gof.behavioural.command.examples.stock;
/**
 * @author Amitava Chakraborty
 * Mar 13, 2002 
 * Concrete class to implement Order 
 */
public class BuyStock implements Order {
	   private Stock abcStock;

	   public BuyStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.buy();
	   }
}