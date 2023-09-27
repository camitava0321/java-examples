/**
 * Singleton pattern
 * A single class which is responsible to create an object while making sure that only single object gets created. 
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 * 
 * Implementation
 * We shall create a SingleObject class. 
 * SingleObject class have its constructor as private and have a static instance of itself.
 * SingleObject class provides a static method to get its static instance to outside world. 
 * This class is the demo class. It uses SingleObject class to get a SingleObject object.
 * 
 * Step 1 - Create a Singleton Class - SingleObject.java
 * Step 2 - Get the only object from the singleton class
 * 
 */
package com.amc.gof.creational.singleton;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {
	   public static void main(String[] args) {

		      //illegal construct
		      //Compile Time Error: The constructor SingleObject() is not visible
		      //SingleObject object = new SingleObject();

		      //Get the only object available
		      SingleObject object = SingleObject.getInstance();

		      //show the message
		      object.showMessage();
		   }

}
