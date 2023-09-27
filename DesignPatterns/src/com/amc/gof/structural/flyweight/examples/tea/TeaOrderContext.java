package com.amc.gof.structural.flyweight.examples.tea;
/**
 * @author Amitava Chakraborty
 * May 1, 2002 
*/

public class TeaOrderContext {  
   int tableNumber; 
   
   TeaOrderContext(int tableNumber) {
       this.tableNumber = tableNumber;
   }
   
   public int getTable() {
       return this.tableNumber;
   }
}
