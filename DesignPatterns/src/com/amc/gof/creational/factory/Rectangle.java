/**
 * 
 */
package com.amc.gof.creational.factory;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}