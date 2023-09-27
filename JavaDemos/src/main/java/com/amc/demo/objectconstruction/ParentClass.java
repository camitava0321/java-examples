/**
 * 
 */
package com.amc.demo.objectconstruction;

/**
 * @author 109365
 *
 */
public class ParentClass {

	public int Avar;
	   public ParentClass() {
	      System.out.println("In Constructor:ParentClass");
	      doSomething();
	   }
	   public void doSomething() {
	      Avar = 1111;
	      System.out.println("In doSomething:ParentClass");
	   }
	
}
