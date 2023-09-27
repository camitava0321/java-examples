/**
 * 
 */
package com.amc.gof.behavioural.observer.examples.stringtype;

/**
 * @author Amitava Chakraborty
 * Apr 25, 2002 
 * Concrete Observer Class 
 */
public class BinaryObserver extends Observer{

	   public BinaryObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Binary String: " 
	      + Integer.toBinaryString( subject.getState() ) ); 
	   }
}