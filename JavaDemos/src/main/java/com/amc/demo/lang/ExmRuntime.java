package com.amc.demo.lang;
import java.io.*;
import java.util.*;

class ExmRuntime 
{
	public static void main(String[] args) throws IOException
	{
		
		/* Use of Runtime Object */
		Runtime env = Runtime.getRuntime();
		
		try{
			System.out.println("Atempting to start a new process");
			Process ps = env.exec("dir ",null);
		} catch (IOException e) {
			System.err.println(e);
		}

		System.out.println("\nJAVA VM Memory");
		System.out.println("\nTotal Memory : " + env.totalMemory() +
			"\nFree Memory : " + env.freeMemory());


		
		/* Use of System Object */
		System.out.println("\nList of keys in the JAVA VM Property List");
		Properties SysProperty = System.getProperties();
		for (Enumeration e=SysProperty.propertyNames();e.hasMoreElements() ;)
		{
		System.out.println(e.nextElement());
		}

		System.out.println("\nList of key values in the JAVA VM Property List");
		SysProperty.list(System.out);
		

	}
}
