/**
 * Visitor pattern
 * A visitor class which changes the executing algorithm of an element class. 
 * By this way, execution algorithm of element can vary as and when visitor varies. 
 * The element object has to accept the visitor object so that visitor object handles the operation on the element object.
 * 
 * Implementation
 * We create a ComputerPart interface defining accept opearation.
 * Keyboard, Mouse, Monitor and Computer are concrete classes implementing ComputerPart interface. 
 * We will define another interface ComputerPartVisitor which will define a visitor class operations. 
 * Computer uses concrete visitor to do corresponding action.
 * 
 * This class is our demo class
 * We will use Computer and ComputerPartVisitor classes to demonstrate use of visitor pattern.
 * 
 * Step 1 - Define an interface to represent element - ComputerPart.java
 * Step 2 - Create concrete classes extending the above class - Keyboard.java, Monitor.java, Mouse.java, Computer.java
 * Step 3 - Define an interface to represent visitor - ComputerPartVisitor.java
 * Step 4 - Create concrete visitor implementing the above class - ComputerPartDisplayVisitor.java
 * Step 5 - Use the ComputerPartDisplayVisitor to display parts of Computer - This class (main method)
 */
package com.amc.gof.behavioural.visitor;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {

	public static void main(String[] args) {

		      ComputerPart computer = new Computer();
		      computer.accept(new ComputerPartDisplayVisitor());
		   }
}
