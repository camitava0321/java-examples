/**
  * Iterator pattern 
  * get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.
  * 
  * We shall create 
  * a Iterator interface which narrates navigation method and 
  * a Container interface which retruns the iterator. 
  * 
  * Concrete classes implementing the Container interface will be responsible to implement Iterator interface and use it.
  * 
  * This demo class will use NamesRepository, a concrete class implementation to print a Names stored as a collection in NamesRepository.
 * 
 */
package com.amc.gof.behavioural.iterator;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {
	   public static void main(String[] args) {
		      NameRepository namesRepository = new NameRepository();

		      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
		         String name = (String)iter.next();
		         System.out.println("Name : " + name);
		      } 	
		   }

}
