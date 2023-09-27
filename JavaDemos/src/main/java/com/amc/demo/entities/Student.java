/**
 * 
 */
package com.amc.demo.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amitava Chakraborty 2009 (ibm)
 *
 */
public class Student {
	   private String firstName;
	   private String lastName;
	   private int rollNo;
	   private String className;
	   private Address address;
	   private List<Note> notes = new ArrayList<Note>();

	   
	   public Student(String name) {
	      this.firstName = name;
	   }
	   
	   public Student() {
		   super();
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName(String firstName) {
	      this.firstName = firstName;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName(String lastName) {
	      this.lastName = lastName;
	   }
	   public int getRollNo() {
	      return rollNo;
	   }
	   public void setRollNo(int rollNo) {
	      this.rollNo = rollNo;
	   }
	   public String getClassName() {
	      return className;
	   }
	   public void setClassName(String className) {
	      this.className = className;
	   }
	   public Address getAddress() {
	      return address;
	   }
	   public void setAddress(Address address) {
	      this.address = address;
	   }
	   public void addNote(Note note) {
		      notes.add(note);
		   }

	   public List<Note> getNotes(){
		      return notes;
		   }

	   public String toString(){
	      StringBuilder stringBuilder = new StringBuilder();
	      stringBuilder.append("Student [ ");
	      stringBuilder.append("\nfirstName: ");
	      stringBuilder.append(firstName);
	      stringBuilder.append("\nlastName: ");
	      stringBuilder.append(lastName);
	      stringBuilder.append("\nrollNo: ");
	      stringBuilder.append(rollNo);
	      stringBuilder.append("\nclassName: ");
	      stringBuilder.append(className);
	      stringBuilder.append("\naddress: ");
	      stringBuilder.append(address);
	      stringBuilder.append(" ]");
	      return stringBuilder.toString();
	   }
}