/**
 * 
 */
package com.amc.gof.structural.bridge.examples.circle;

/**
 * @author Amitava Chakraborty
 * Sep 29, 2002
 * Abstract class Shape uses the DrawAPI interface. 
 */
public abstract class Shape {
	   protected DrawAPI drawAPI;
	   protected Shape(DrawAPI drawAPI){
	      this.drawAPI = drawAPI;
	   }
	   public abstract void draw();	
}