/**
 * 
 */
package com.amc.gof.structural.adapter.examples.audio;

/**
 * @author Amitava Chakraborty
 * Aug 23, 2002 
 */
public class VLCPlayer implements AdvancedMediaPlayer{
	   @Override
	   public void playVlc(String fileName) {
	      System.out.println("Playing vlc file. Name: "+ fileName);		
	   }

	   @Override
	   public void playMp4(String fileName) {
	      //do nothing
	   }
}