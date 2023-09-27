/**
 * 
 */
package com.amc.gof.creational.builder;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Pepsi extends ColdDrink {

   @Override
   public float price() {
      return 35.0f;
   }

   @Override
   public String name() {
      return "Pepsi";
   }
}
