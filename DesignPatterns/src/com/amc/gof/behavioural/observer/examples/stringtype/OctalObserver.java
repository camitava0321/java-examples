/**
 * 
 */
package com.amc.gof.behavioural.observer.examples.stringtype;
/**
 * @author Amitava Chakraborty
 * Apr 25, 2002 
 */
public class OctalObserver extends Observer{

	   public OctalObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
	     System.out.println( "Octal String: " 
	     + Integer.toOctalString( subject.getState() ) ); 
	   }
}