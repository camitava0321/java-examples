/**
 * 
 */
package com.amc.gof.creational.builder;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public abstract class Burger implements Item {

   @Override
   public Packing packing() {
      return new Wrapper();
   }

   @Override
   public abstract float price();
}
