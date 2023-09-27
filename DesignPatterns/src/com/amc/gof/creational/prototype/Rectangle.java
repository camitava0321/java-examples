/**
 * 
 */
package com.amc.gof.creational.prototype;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Rectangle extends Shape {

   public Rectangle(){
     type = "Rectangle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
