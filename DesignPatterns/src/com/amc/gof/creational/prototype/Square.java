/**
 * 
 */
package com.amc.gof.creational.prototype;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Square extends Shape {

   public Square(){
     type = "Square";
   }

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

