package com.amc.java.practice.serialization;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Part of the object serialization "Angry Object Salad" example.
 * This class is just an object that will hold some data that can be
 * serialized.
 */

public class RequestParam extends ServiceParam implements Serializable {
   static final long serialVersionUID = 7110175216435025451L;
	private String origin;      // an OBJECT
	private float redness;      // a PRIMITIVE
	private Vector seeds;       // a CONTAINER
	private String junk;

   public RequestParam(String from, int children, float redness) {
		created = new Date();
		origin = from;
		seeds = new Vector();
		this.redness = redness;

		for(int count = 0; count < children; count++) {
			seeds.addElement(new DataAttribute());
		}   // for
	}

	public void showSelf() {
		System.out.println(this.getClass().getName()+" created at about "+
		                   makeDateString());
		System.out.println("I am from "+origin+" and of redness "+redness);

		for(int count = 0; count < seeds.size(); count++) {
			// the usual case when working with a Vector
		   ((DataAttribute)seeds.elementAt(count)).printSelf();
		}   // for

		System.out.println("End of Tomato data");
	}
}
