package com.amc.demo.lang;
class exmChars 
{
	public static void main(String[] args) 
	{
		
	Character	Ch1 = new Character('A');						// Creating a new Character Object
	char	ch1 = Ch1.charValue();								// A new char variable
	Character	Ch2	= new Character('F');

	System.out.println("First Obj : " + Ch1 +
		"Second Obj : " + Ch2 +
		"Comparison Result : " + Ch2.equals(Ch1));


	}
}
