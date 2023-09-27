package com.amc.demo.util;
/** BitSet is a class declared as final, so further subclassing is not allowed */
/*  All the methods of a BitSet class is declared as not static, ie. an
 *  instantiation is mandatory
 */
import java.util.*;

public class Bitset1
{

	public static void main (String [] args)
	{
	int sInteger;
	try
	{
		sInteger = Integer.valueOf(args[0]).intValue();
	} catch (ArrayIndexOutOfBoundsException e)
	{
		System.out.println(
			"Usage : Bitset1 <no_of_bits>\n"+
			"A bit length 16 is used \n");
		sInteger = 16;
	}

	// How to create Bitsets
	BitSet bitset1 = new BitSet();	// Specifies a size of 64 minimum

	// To specify a size greter that 64; The values are 128,196,256 and so on
	// If one specifies size as 65 it automatically sets the size to the next possible value 128
	// If one specifies size as 129 it automatically sets the size to the next possible value 192(128+64)
	BitSet bitset2 = new BitSet(sInteger);

	System.out.println(
		"Size of bitset1 : "+bitset1.size()+"\n"+
		"Size of bitset2 : "+bitset2.size()+"\n\n"
		);
	System.out.println("bitset1 : "+bitset1+"\n"+
		"bitset2 : "+bitset2+"\n\n");

	bitset1.set(64);
	bitset2.set(63);
	System.out.println("bitset1 : "+bitset1+"\n"+
		"bitset2 : "+bitset2+"\n\n");

	//Performing an OR on bitset1 (bitset1 will be changed
	bitset1.or(bitset2);
	bitset1.and(bitset2);
	System.out.println("bitset1 : "+bitset1+"\n"+
		"bitset2 : "+bitset2+"\n\n");

	}
	
}
