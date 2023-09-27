/**
 * 
 */
package com.amc.gof.structural.bridge.examples.circle;

/**
 * @author Amitava Chakraborty
 * Sep 29, 2002
 * Concrete class implementing the Shape interface 
 */
public class Circle extends Shape {
	   private int x, y, radius;

	   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
	      super(drawAPI);
	      this.x = x;  
	      this.y = y;  
	      this.radius = radius;
	   }

	   public void draw() {
	      drawAPI.drawCircle(radius,x,y);
	   }
}