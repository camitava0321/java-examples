/**
 * Facade pattern 
 * Hides the complexities of the system and provides an interface to the client using which the client can access the system. 
 * 
 * The pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
 * 
 * Implementation
 * We have a Shape interface and concrete classes implementing the Shape interface. 
 * A facade class ShapeMaker uses the concrete classes to delegate user calls to these classes. 
 * This demo will use ShapeMaker class to show the results.
 * Step 1 - Create an interface - Shape.java
 * Step 2 - Create concrete classes implementing the same interface - Rectangle.java, Square.java, Circle.java
 * Step 3 - Create a facade class - ShapeMaker.java
 * Step 4 - Use the facade to draw various types of shapes.
 */
package com.amc.gof.structural.facade;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {
	   public static void main(String[] args) {
		      ShapeMaker shapeMaker = new ShapeMaker();

		      shapeMaker.drawCircle();
		      shapeMaker.drawRectangle();
		      shapeMaker.drawSquare();		
		   }
}
