package com.amc.java.practice.serialization;
import java.io.*;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * This class is a simple demonstration of de-serializing some objects from a
 * file.
 */

public class ObjectParamReader {
	public static void main(String[] args) {
      File theFile;
		FileInputStream inStream;
		ObjectInputStream objStream;

		if(args.length != 1) {
			// wrong arguments
			System.err.println("Use: java ObjectSaladReader junk_out");
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

			// read the primitive data
			int primitive = objStream.readInt();

			// read the objects
			// you need to know what type they are
			// QUESTION: What happens if you change the order of these two lines?
			ServiceParam crunch = (ServiceParam)objStream.readObject();
			Object tomato = objStream.readObject();

			// close down the streams
			objStream.close();
			inStream.close();

 // streams are now closed, lets see what we got...
			System.out.println("The primitive was "+primitive);
			crunch.showSelf();

			// cast needed since we only know it is an Object right now
			((RequestParam)tomato).showSelf();

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

