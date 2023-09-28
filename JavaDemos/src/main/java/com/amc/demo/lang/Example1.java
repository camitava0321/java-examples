package com.amc.demo.lang;

import com.amc.demo.datatype.Complex;

class Example1 
{
	public static void main(String[] args) 
	{
	Complex u, v, w, z;    
	u = new Complex(1,2);
    u.Print("u: ");

	v = new Complex(3,-4.5);
	v.Print("v: ");
    
	// Add u + v;    
	z=u.Plus(v);
    System.out.println("u + v: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	// Add v + u;    
	z=v.Plus(u);
    System.out.println("v + u: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=u.Minus(v);
    System.out.println("u - v: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=v.Minus(u);
    System.out.println("v - u: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=u.Times(v);
    System.out.println("u * v: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=v.Times(u);
    System.out.println("v * u: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=u.DivideBy(v);
    System.out.println("u / v: "+ z.Real() + " + " + z.Imaginary() + "i");
    
	z=v.DivideBy(u);
    System.out.println("v / u: "+ z.Real() + " + " + z.Imaginary() + "i");

	//Complex number - Self Operations
	z=u.Plus(u);
	z.Print("Added to self : ");

	z=u.Minus(u);
	z.Print("Subtracted from self : ");

	z=u.Times(u);
	z.Print("Multiplied to self : ");

	z=u.DivideBy(u);
	z.Print("Divided by self : ");

	}

}
