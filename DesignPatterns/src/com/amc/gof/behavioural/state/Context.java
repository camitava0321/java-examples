/**
 * 
 */
package com.amc.gof.behavioural.state;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */

public class Context {
   private State state;

   public Context(){
      state = null;
   }

   public void setState(State state){
      this.state = state;		
   }

   public State getState(){
      return state;
   }
}

