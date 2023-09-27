/**
 * 
 */
package com.amc.gof.behavioural.visitor;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Mouse implements ComputerPart {

   @Override
   public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
   }
}

