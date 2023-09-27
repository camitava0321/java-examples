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

 // try taking away the Serializable and see if serialization of a Tomato
 // object will work

public class DataAttribute implements Serializable {

	public void printSelf() {
		System.out.println("TomatoSeed says hi, the current time is "+
		                    System.currentTimeMillis());
	}

}

