package com.amc.java.practice.serialization;

import java.io.*;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Driver for a demo which tests objects that are using custom read/write
 * methods to perform serialization.
 */

public class AdvancedReader {
	public static void main(String[] args) {
      File theFile;
		FileInputStream inStream;
		ObjectInputStream objStream;

		if(args.length != 1) {
			// wrong arguments
			System.err.println("Use: java AdvancedReader junk_out");
			System.exit(1);
		}   // if

		theFile = new File(args[0]);

		// look for an existing file
		if(!theFile.exists()) {
			System.err.println("File "+theFile.getAbsolutePath()+
			                   " does not exist.");
			System.exit(1);
		}

      try {
			// setup a read from physical file on the filesystem
			inStream = new FileInputStream(theFile);

			// attach a stream capable of writing objects to the stream that is
			// connected to the file
			objStream = new ObjectInputStream(inStream);

			// read the object
			UserInfo user = (UserInfo)objStream.readObject();

			// close down the streams
			objStream.close();
			inStream.close();
		} catch(IOException e) {
			System.err.println("Things not going as planned.");
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
		   System.err.println("Things not going as planned.");
			e.printStackTrace();
      } catch(ClassCastException e) {
			// end up here if one of the objects were read wrong
			System.err.println("Cast didn't work quite right.");
			e.printStackTrace();
		}   // catch

	}
}

