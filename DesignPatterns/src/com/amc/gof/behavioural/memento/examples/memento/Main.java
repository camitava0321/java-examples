/**
 * 
 */
package com.amc.gof.behavioural.memento.examples.memento;

/**
 * @author Amitava Chakraborty
 * Oct 4, 2002 
 * Memento pattern is used to reduce where we want to restore state 
 * of an object to a previous state. 
 * 
 * The pattern uses three actor classes. 
 * 1) Memento - contains state of an object to be restored. 
 * 2) Originator - creates and stores states in Memento objects
 * 3) Caretaker - responsible to restore object state from Memento. 
 *  
 */
public class Main {
	   public static void main(String[] args) {
		      Originator originator = new Originator();
		      CareTaker careTaker = new CareTaker();

		      //Set states in objects.
		      //state of the object is changed but not saved in a Memento
		      originator.setState("State #1");
		      //state of the object is changed again and saved in a Memento
		      originator.setState("State #2");
		      careTaker.add(originator.saveStateToMemento());
		      //state of the object is changed again and saved in a Memento
		      originator.setState("State #3");
		      careTaker.add(originator.saveStateToMemento());
		      //current state of the object - not saved in a Memento
		      originator.setState("State #4");

		      System.out.println("Current State: " + originator.getState());
		      //Restores the state in Originator from a Memento object
		      originator.getStateFromMemento(careTaker.get(0));
		      System.out.println("First saved State: " + originator.getState());
		      //Restores the state in Originator from a Memento object
		      originator.getStateFromMemento(careTaker.get(1));
		      System.out.println("Second saved State: " + originator.getState());
		   }
}