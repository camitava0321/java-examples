/**
 * 
 */
package com.amc.gof.structural.decorator.examples.shape;

/**
 * @author Amitava Chakraborty
 * Oct 21, 2002
 * Concrete classes implementing Shape 
 */
public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}

