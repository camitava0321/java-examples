/**
 * 
 */
package com.amc.gof.creational.builder;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Bottle implements Packing {

   @Override
   public String pack() {
      return "Bottle";
   }
}
