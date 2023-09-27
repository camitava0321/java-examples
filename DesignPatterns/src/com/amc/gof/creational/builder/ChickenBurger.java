/**
 * 
 */
package com.amc.gof.creational.builder;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class ChickenBurger extends Burger {

   @Override
   public float price() {
      return 50.5f;
   }

   @Override
   public String name() {
      return "Chicken Burger";
   }
}