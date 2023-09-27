/**
  * StudentBO is a Business Object and StudentVO is a Transfer Object that represents the corresponding business entity.
  */
package com.amc.others.transferobject;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class StudentVO {
	   private String name;
	   private int rollNo;

	   StudentVO(String name, int rollNo){
	      this.name = name;
	      this.rollNo = rollNo;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public int getRollNo() {
	      return rollNo;
	   }

	   public void setRollNo(int rollNo) {
	      this.rollNo = rollNo;
	   }
}