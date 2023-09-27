/**
 * 
 */
package com.amc.gof.structural.facade;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}

