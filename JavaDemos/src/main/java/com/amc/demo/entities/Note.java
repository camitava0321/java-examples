/**
 * 
 */
package com.amc.demo.entities;

/**
 * @author Amitava Chakraborty 2009 (ibm)
 *
 */
public class Note {
	   private String title;
	   private String description;

	   public Note(String title, String description) {
	      this.title = title;
	      this.description = description;
	   }

	   public String getTitle(){
	      return title;
	   }

	   public String getDescription(){
	      return description;
	   }     
}