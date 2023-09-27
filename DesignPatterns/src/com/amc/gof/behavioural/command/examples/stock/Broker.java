/**
 * 
 */
package com.amc.gof.behavioural.command.examples.stock;
/**
 * @author Amitava Chakraborty
 * Mar 13, 2002 
 * Command Invoker 
 */
import java.util.ArrayList;
import java.util.List;

   public class Broker {
   private List<Order> orderList = new ArrayList<Order>(); 

   public void takeOrder(Order order){
      orderList.add(order);		
   }

   public void placeOrders(){
      for (Order order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}