/**
 * 
 */
package com.amc.gof.structural.decorator.examples.shape;

/**
 * @author Amitava Chakraborty
 * Oct 21, 2002
 * Uses the RedShapeDecorator to decorate Shape objects. 
 */
public class Main {
	   public static void main(String[] args) {

		      Shape circle = new Circle();

		      Shape redCircle = new RedShapeDecorator(new Circle());

		      Shape redRectangle = new RedShapeDecorator(new Rectangle());
		      System.out.println("Circle with normal border");
		      circle.draw();

		      System.out.println("\nCircle of red border");
		      redCircle.draw();

		      System.out.println("\nRectangle of red border");
		      redRectangle.draw();
		   }
}