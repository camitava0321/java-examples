/**
 * 
 */
package com.amc.gof.creational.prototype;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Circle extends Shape {

   public Circle(){
     type = "Circle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}

