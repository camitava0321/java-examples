/**
 * 
 */
package com.amc.gof.structural.decorator.examples.shape;

/**
 * @author Amitava Chakraborty
 * Oct 21, 2002
 * abstract decorator class implementing the Shape interface. 
 */
public abstract class ShapeDecorator implements Shape {
   protected Shape decoratedShape;

   public ShapeDecorator(Shape decoratedShape){
      this.decoratedShape = decoratedShape;
   }

   public void draw(){
      decoratedShape.draw();
   }	
}

