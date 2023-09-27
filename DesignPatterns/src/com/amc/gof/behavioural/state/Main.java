/**
 * State pattern 
 * a class behavior changes based on its state. 
 * In this pattern, we create objects which represent various states and a context object whose behavior varies as its state object changes.
 * 
 * We shall create a State interface defining an action and 
 * concrete state classes implementing the State interface. 
 * Context is a class which carries a State.
 * 
 * This is the demo class
 * uses Context and state objects to demonstrate change in Context behavior based on type of state it is in.
 * Step 1 - Create an interface - State.java
 * Step 2 - Create concrete classes implementing the same interface - StartState.java, StopState.java
 * Step 3 - Create Context Class - Context.java
 * Step 4 - Use the Context to see change in behaviour when State changes.
 * 
 */
package com.amc.gof.behavioural.state;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {
	   public static void main(String[] args) {
		      Context context = new Context();

		      StartState startState = new StartState();
		      startState.doAction(context);

		      System.out.println(context.getState().toString());

		      StopState stopState = new StopState();
		      stopState.doAction(context);

		      System.out.println(context.getState().toString());
		   }
}