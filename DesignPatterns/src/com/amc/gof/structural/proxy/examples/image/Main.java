/**
 * 
 */
package com.amc.gof.structural.proxy.examples.image;

/**
 * @author Amitava Chakraborty
 * Aug 11, 2002 
 */
public class Main {
	   public static void main(String[] args) {
		      Image image = new ProxyImage("test_10mb.jpg");

		      //image will be loaded from disk
		      image.display(); 
		      System.out.println("");
		      //image will not be loaded from disk
		      image.display(); 	
		   }
}
