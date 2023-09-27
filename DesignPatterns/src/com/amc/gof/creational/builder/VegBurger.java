/**
 * 
 */
package com.amc.gof.creational.builder;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class VegBurger extends Burger {

   @Override
   public float price() {
      return 25.0f;
   }

   @Override
   public String name() {
      return "Veg Burger";
   }
}

