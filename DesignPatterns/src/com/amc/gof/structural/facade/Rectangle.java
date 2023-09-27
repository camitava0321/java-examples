/**
 * 
 */
package com.amc.gof.structural.facade;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}

