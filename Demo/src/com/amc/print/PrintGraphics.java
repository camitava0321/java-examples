/**
 * This class prints graphics objects in a print object directly.
 * This print object can be any system printers including PDF printers.
 * To print custom AWT components, one can use the paint methods and pass the graphics context 
 * returned by getGraphics. 
 */
 
package com.amc.print;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;

/**
 * @author Amitava Chakraborty 
 * 15/07/2003
 */

public class PrintGraphics {

	public static void main(String args[]) {
		//It creates an AWT frame, a top-level GUI component for running the application. 
		Frame f = new Frame("test");
		f.pack();

		//Retrieves the toolkit for the frame. 
		//The toolkit for the AWT is the interface between the abstract window layer 
		//and an actual windowing implementation (Windows 2000 or X Windows)
		//Once the toolkit is created, one can initiate a print job via getPrintJob, 
		//This will open a printer dialog OS pop up - exactly similar popup to print any other conventional doc
		PrintJob pj = f.getToolkit().getPrintJob(f, "print1", null);

		if (pj != null) {
			//On a PrintJob object, a graphics context is obtained
			Graphics g = pj.getGraphics();

			//On this context one can draw just anything (such as fillOval)
			//The drawing goes to the printer directly instead of the screen. 
			g.fillOval(5, 5, 150, 100);

			//Calling dispose on the graphics context object sends the page to the printer
			g.dispose();

			//The print job is terminated by calling end.
			pj.end();
		}
		System.exit(0);
	}
}