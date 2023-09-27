package com.amc.demo.lang;
class exmBytes 
{
	public static void main(String[] args) 
	{

	byte abc;										// Declares a variable of type byte
	abc=10;											// Assigns value 10 to the variable
		Byte btValue = new Byte(abc);				// Creates an object of type Byte

		System.out.println(							// Prints the range for a Byte 
			"Range of a Byte object : from " + 
			btValue.MAX_VALUE + " to " + 
			btValue.MIN_VALUE);
													// Conversion of a Byte into other Objects
		System.out.println(
		"Byte Object Value : " + btValue + 
		"\nByte Value : " + btValue.byteValue() +
		"\nLong Eqv : " + btValue.longValue() +
		"\nInt Eqv : " + btValue.intValue() +
		"\nShort Eqv : " + btValue.shortValue() +
		"\nDouble Eqv : " + btValue.doubleValue() +
		"\nFloat Eqv : " + btValue.floatValue() +
		"\nString Eqv : " + btValue.toString()
		);
	
	// Displaying some more methods of Byte Object
	byte bytAnother=10;
	Byte bytOAnother=Byte.decode("110");			// Creating new object by assigning
													// decode method converts String to Byte

  	int	sCompResult = 0;					// Compares Byte to Byte or other Objects
//btValue.compareTo(bytOAnother);				// Results 0 if equal, (btValue - bytOAnother)
													// if not equal

	System.out.println(
		sCompResult + "  " + 
		btValue.equals(bytOAnother));

	// Displaying some more methods of Byte Object
	// Parsing Strings

  	bytAnother = Byte.parseByte("110");
	Byte bytOYetAnother = Byte.valueOf("126");		// Using 129 will give NumberFormaException
													// because a Byte Range is -127 to 128

	System.out.println(bytAnother + "     " + bytOYetAnother);
	}
}
