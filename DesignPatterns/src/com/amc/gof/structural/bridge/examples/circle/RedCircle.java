/**
 * 
 */
package com.amc.gof.structural.bridge.examples.circle;

/**
 * @author Amitava Chakraborty
 * Sep 29, 2002 
 */
public class RedCircle implements DrawAPI {
	   @Override
	   public void drawCircle(int radius, int x, int y) {
	      System.out.println("Drawing Circle[ color: red, radius: "
	         + radius +", x: " +x+", "+ y +"]");
	   }
}