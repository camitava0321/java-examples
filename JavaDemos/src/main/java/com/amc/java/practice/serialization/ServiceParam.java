package com.amc.java.practice.serialization;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Part of the object serialization "Angry Object Salad" example.
 * This class is just an object that will hold some data that can be
 * serialized.
 */

public abstract class ServiceParam extends Object implements Serializable {
	protected Date created;        // an OBJECT

	public abstract void showSelf();

/**
 * Give a string representation of whatever date is attached.
 */
	protected String makeDateString() {
      SimpleDateFormat formatter = new SimpleDateFormat("kk:mm, dd MMM yy");

      if(created == null) {
			return null;
		} else {
			return formatter.format(created);
		}   // else
	}
}

