/**
 * 
 */
package com.amc.gof.creational.singleton;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class SingleObject {

   private long id=123456789;
   //create an object of SingleObject
   private static SingleObject instance = new SingleObject();

   //make the constructor private so that this class cannot be
   //instantiated
   private SingleObject(){}

   //Get the only object available
   public static SingleObject getInstance(){
      return instance;
   }

   public void showMessage(){
      System.out.println("Hello World!");
   }

/**
 * @return the id
 */
public long getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}
   
   
}

