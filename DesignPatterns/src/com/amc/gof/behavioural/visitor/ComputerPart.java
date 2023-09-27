/**
 * 
 */
package com.amc.gof.behavioural.visitor;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}

