package com.amc.demo.lang;
/** Example of simple threading
 *  Two threads NumberThread and SQRootThread are subclasses of a GenericThread
 *	NumberThread populates array sNumbers with integers
 *	SQRootThread populates another array dSQRoots with square roots of the intgers in sNumber array
 *	main runs the two threads
 *	Thread SQRootThread implements a sleep to let the sNumbers array be populated before 
 *	working on that
 */
public class Thread1
{

	public static void main (String [] args)
	{
		try
		{
			// Instantiating a GenericThread passing the sSleepUnit 
			// sSleepUnit - specifies SQRootThread how long to sleep 
			// before working on the sNumbers array
			GenericThread genThrd = new GenericThread(Integer.valueOf(args[0]).intValue());
		}
		catch (Exception e)
		{
			// If any exception occurs specifies a sSleepUnit = 0
			GenericThread genThrd = new GenericThread(0);
		}
	
	NumberThread thrd1 = new NumberThread();
	SQRootThread thrd2 = new SQRootThread();

		thrd2.start();	// Start SQRootThread first
		thrd1.start();	// Start NumberThread next
	}
};

class GenericThread extends Thread
{
	public static int MAX_NO = 100;	// Size of Arrays
	public static int sSleep = 1;	// Sleeptime for SQRootThread
	
	// static arrays
	public static int [] sNumbers = new int[MAX_NO];
	public static double [] dSQRoots = new double[MAX_NO];
	
	// default constructor
	GenericThread() {
//		super();
	}

	// customised constructor
	GenericThread(int sSleepUnit){
//		super();
		sSleep = sSleepUnit;
	}

};

class NumberThread extends GenericThread 
{
	public void run()
	{
		System.out.println("NumberThread Started");
		for (int i=0;i<MAX_NO;i++) 
		{
			sNumbers[i]=(i+1)*10;
			System.out.println("Number : " +sNumbers[i]);
		}
		System.out.println("NumberThread Finished");

	}
}

class SQRootThread extends GenericThread
{
	public void run()
	{
		System.out.println("SQRootThread Strated");
		for (int i=0;i<MAX_NO;i++) 
		{
			try{
				sleep(sSleep);
			}catch(Exception e) {
				e.printStackTrace();
			}

			dSQRoots[i]=Math.sqrt(sNumbers[i]);
			System.out.println("Square Root of " + sNumbers[i] +
				" is  : "+dSQRoots[i]);
		}
		System.out.println("SQRootThread Finished");
	}
};

