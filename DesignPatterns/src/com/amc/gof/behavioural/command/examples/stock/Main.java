/**
 * 
 */
package com.amc.gof.behavioural.command.examples.stock;
/**
 * @author Amitava Chakraborty
 * Mar 13, 2002 
 */
public class Main {
	   public static void main(String[] args) {
		      Stock abcStock = new Stock();

		      BuyStock buyStockOrder = new BuyStock(abcStock);
		      SellStock sellStockOrder = new SellStock(abcStock);

		      Broker broker = new Broker();
		      broker.takeOrder(buyStockOrder);
		      broker.takeOrder(sellStockOrder);

		      broker.placeOrders();
		   }
}
