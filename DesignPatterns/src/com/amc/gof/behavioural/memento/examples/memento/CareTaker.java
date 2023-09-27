/**
 * 
 */
package com.amc.gof.behavioural.memento.examples.memento;

/**
 * @author Amitava Chakraborty
 * Oct 4, 2002 
 * Restores state of an object from Memento.
 */
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
   private List<Memento> mementoList = new ArrayList<Memento>();

   public void add(Memento state){
      mementoList.add(state);
   }

   public Memento get(int index){
      return mementoList.get(index);
   }
}