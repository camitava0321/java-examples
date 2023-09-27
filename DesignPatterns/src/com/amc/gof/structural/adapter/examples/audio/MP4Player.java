/**
 * 
 */
package com.amc.gof.structural.adapter.examples.audio;

/**
 * @author Amitava Chakraborty
 * Aug 23, 2002 
 */
public class MP4Player implements AdvancedMediaPlayer{

	   @Override
	   public void playVlc(String fileName) {
	      //do nothing
	   }

	   @Override
	   public void playMp4(String fileName) {
	      System.out.println("Playing mp4 file. Name: "+ fileName);		
	   }
}