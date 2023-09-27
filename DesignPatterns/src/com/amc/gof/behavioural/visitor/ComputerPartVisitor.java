/**
 * 
 */
package com.amc.gof.behavioural.visitor;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public interface ComputerPartVisitor {
	public void visit(Computer computer);
	public void visit(Mouse mouse);
	public void visit(Keyboard keyboard);
	public void visit(Monitor monitor);
}

