/**
 * 
 */
package com.amc.demo.objectconstruction;

/**
 * @author 109365
 *
 */
public class SubClass extends ParentClass{
	public int Bvar = 2222;
	   public SubClass() {
	      System.out.println("In Constructor:SubClass");
	      doSomething();
	      System.out.println("Avar=" + Avar);
	   }
	   public void doSomething() {
	      System.out.println("Bvar=" + Bvar);
	   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	      new SubClass();
	}

}
