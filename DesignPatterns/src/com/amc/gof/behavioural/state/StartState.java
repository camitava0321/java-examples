/**
 * 
 */
package com.amc.gof.behavioural.state;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class StartState implements State {

   public void doAction(Context context) {
      System.out.println("Player is in start state");
      context.setState(this);	
   }

   public String toString(){
      return "Start State";
   }
}

