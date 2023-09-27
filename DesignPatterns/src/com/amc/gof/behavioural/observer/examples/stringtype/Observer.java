/**
 * 
 */
package com.amc.gof.behavioural.observer.examples.stringtype;
/**
 * @author Amitava Chakraborty
 * Apr 25, 2002 
 */
public abstract class Observer {
	   protected Subject subject;
	   public abstract void update();
}