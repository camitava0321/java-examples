package com.amc.demo.datatype;
public class Complex extends Object
{
	private double u;  
	private double v;  
	
		public Complex (double x, double y) {    
			u=x;
			v=y;  
		}  
		
		public double Real () 
		{    return u;  }
  
		public double Imaginary () 
		{    return v;  }  
		
		public double Magnitude () {
			return Math.sqrt(u*u + v*v);  }  
			
		public double Arg () {
			return Math.atan2(u, v);  }  // Add z to w; i.e. w += z
  
		public Complex Plus (Complex z) {        
			return new Complex(u + z.u, v + z.v);
		}  
		
		// Subtract z from w  
		public Complex Minus (Complex z) {
			return new Complex(u - z.u, v - z.v);  }
		
		public Complex Times (Complex z) {
			return new Complex(u*z.u - v*z.v, u*z.v + v*z.u);      
		}  
		// divide w by z
  
		public Complex DivideBy (Complex z) {    
			double rz = z.Magnitude(); 
			return new Complex((u * z.u + v * z.v)/(rz*rz),(v * z.u - u * z.v)/(rz*rz));
		}

	public void Print(String szCaption)
	{
	System.out.print(szCaption);
	System.out.println(u + " + " + v + "i");
	}

}