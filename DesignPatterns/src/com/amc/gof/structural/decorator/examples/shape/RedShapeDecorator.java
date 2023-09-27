/**
 * 
 */
package com.amc.gof.structural.decorator.examples.shape;

/**
 * @author Amitava Chakraborty
 * Oct 21, 2002
 * Concrete decorator class extending the ShapeDecorator class. 
 */
public class RedShapeDecorator extends ShapeDecorator {

   public RedShapeDecorator(Shape decoratedShape) {
      super(decoratedShape);		
   }

   @Override
   public void draw() {
      decoratedShape.draw();	       
      setRedBorder(decoratedShape);
   }

   private void setRedBorder(Shape decoratedShape){
      System.out.println("Border Color: Red");
   }
}
