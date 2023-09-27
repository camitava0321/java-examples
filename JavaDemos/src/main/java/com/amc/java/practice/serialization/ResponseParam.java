package com.amc.java.practice.serialization;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Part of the object serialization "Angry Object Salad" example.
 * This class is just an object that will hold some data that can be
 * serialized.
 */

public class ResponseParam extends ServiceParam implements Serializable {
	private long[] times;        // ARRAY of PRIMITIVES
	private String brokenClass;

   public ResponseParam(int crumbs) {
		times = new long[crumbs];
      created = new Date();       // object will have current time

      // fill array with useless data
		for(int count = 0; count < crumbs; count++) {
			times[count] = System.currentTimeMillis();
		}   // for
	}

	public void showSelf() {
		System.out.println(this.getClass().getName()+" created at about "+
		                   makeDateString());

		for(int count = 0; count < times.length; count++) {
			System.out.println(times[count]);
		}   // for

		System.out.println("End of Crouton data");
	}
}

