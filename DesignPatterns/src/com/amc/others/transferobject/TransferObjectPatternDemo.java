/**
 * The Demo class - acting as a client to a server. 
 * The class uses the Transfer Object as a read-only representation of the business entity. 
 */
package com.amc.others.transferobject;

/**
 * @author Amitava Chakraborty
 * Nov 12, 2002 
 */
public class TransferObjectPatternDemo {
	   public static void main(String[] args) {
	      StudentBO studentBusinessObject = new StudentBO();

	      //print all students
	      for (StudentVO student : studentBusinessObject.getAllStudents()) {
	         System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	      }

	      //update student
	      StudentVO student = studentBusinessObject.getAllStudents().get(0);
	      student.setName("Michael");
	      studentBusinessObject.updateStudent(student);

	      //get the student
	      student = studentBusinessObject.getStudent(0);
	      System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	   }
}