package com.amc.java.practice.serialization;

import java.io.*;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Demonstration that serializes objects which are implementing custom read
 * and write methods.
 */

public class AdvancedWriter {
	public static void main(String[] args) {
      File theFile;
		FileOutputStream outStream;
		ObjectOutputStream objStream;

		if(args.length != 1) {
			// wrong arguments
			System.err.println("Use: java AdvancedWriter junk_out");
			System.exit(1);
		}   // if

		theFile = new File(args[0]);

		// look for an existing file
		if(theFile.exists()) {
			System.err.println("File "+theFile.getAbsolutePath()+
			                   " already exists, please zap it.");
			System.exit(1);
		}

      try {
			// setup a stream to a physical file on the filesystem
			outStream = new FileOutputStream(theFile);

			// attach a stream capable of writing objects to the stream that is
			// connected to the file
			objStream = new ObjectOutputStream(outStream);

			// write some objects
			objStream.writeObject(new UserInfo("juser", 12345, "secret",
               			                    "/home/juser" ));

			// close down the streams
			objStream.flush();
			objStream.close();
			outStream.flush();
			outStream.close();
		} catch(IOException e) {
			System.err.println("Things not going as planned.");
			e.printStackTrace();
		}   // catch

	}
}

