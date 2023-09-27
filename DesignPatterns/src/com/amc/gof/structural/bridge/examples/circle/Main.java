/**
 * 
 */
package com.amc.gof.structural.bridge.examples.circle;

/**
 * @author Amitava Chakraborty
 * Sep 29, 2002 
 * Uses Shape and DrawAPI classes to draw different colored circles.
 */
public class Main {
	   public static void main(String[] args) {
		      Shape redCircle = new Circle(100,100, 10, new RedCircle());
		      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

		      redCircle.draw();
		      greenCircle.draw();
		   }
}