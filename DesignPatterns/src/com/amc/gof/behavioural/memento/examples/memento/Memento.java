/**
 * 
 */
package com.amc.gof.behavioural.memento.examples.memento;

/**
 * @author Amitava Chakraborty
 * Oct 4, 2002 
 * Stores state of an object to be restored.
 */
public class Memento {
    
	//An object whose state is being stored.
	private String state;

   public Memento(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }	
}