package com.amc.demo.lang;
class exmBooleans 
{
	public static void main(String[] args) 
	{
//		Boolean bool = new Boolean(); // Gives error message as no such constructor exist in java.lang.Boolean
//		System.out.println(bool);

		Boolean bool1 = new Boolean(true);
		System.out.println(bool1);

		Boolean bool2 = new Boolean("FALSE");
		System.out.println(bool2);
		
		System.out.println(bool2.booleanValue());
		System.out.println(Boolean.valueOf("TRUE"));
		System.out.println(bool2.toString());

		
		String szProperty = new String();
		szProperty = System.getProperty("java.lang.String");
//		bool2.getBoolean(szProperty);
		System.out.println(szProperty + "value : " + bool2);

	}
}
