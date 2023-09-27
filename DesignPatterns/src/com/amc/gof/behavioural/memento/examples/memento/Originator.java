/**
 * 
 */
package com.amc.gof.behavioural.memento.examples.memento;

/**
 * @author Amitava Chakraborty
 * Oct 4, 2002 
 * Creates and stores states in Memento objects.
 */
public class Originator {
   
   //Object to be created with a state.	
   private String state;

   //Set state of an object
   public void setState(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }

   //Create Memento objects to restore this state of 'state' object
   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento Memento){
      state = Memento.getState();
   }
}