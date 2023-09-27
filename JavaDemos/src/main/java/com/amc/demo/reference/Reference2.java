package com.amc.demo.reference;
import java.awt.*;
import java.lang.reflect.*;

public class  Reference2
{
	static Class master;
	Reference2(Class c) {
		master = c;
	}
	
	public static void printAll()
	{
		int sCount=0,sCount2=0;
		StringBuffer szTabs = new StringBuffer();
		Class subClass = master;

		System.out.println(master);	
		System.out.println("Class Name : "+master.getName());	

		Class superClass = subClass.getSuperclass();
		System.out.println("Superclasses : ");	

		while (superClass!=null)
		{
			for (sCount2=0;sCount2<sCount ;sCount2++ )
			{
				szTabs.append("\t");
			}
			System.out.println(szTabs.toString()+superClass.getName());	
			szTabs.setLength(0);
			subClass = superClass;
			superClass = subClass.getSuperclass();
			sCount++;
		}

		int m = master.getModifiers();

		if(Modifier.isPublic(m))
		{
			System.out.print("\tpublic");
		}
		if(Modifier.isPrivate(m))
		{
			System.out.print("\tprivate");
		}
		if(Modifier.isProtected(m))
		{
			System.out.print("\tprotected");
		}
		if(Modifier.isAbstract(m))
		{
			System.out.print("\tabstract");
		}
		if(Modifier.isFinal(m))
		{
			System.out.print("\tfinal");
		}
		if(Modifier.isStatic(m))
		{
			System.out.print("\tstatic");
		}
		System.out.println();

	}

	public void printFields()
	{
		Field [] publicFields = master.getFields();
		Class fieldType; 

		for (int i=0;i<publicFields.length ;i++ )
		{
			System.out.println("Field "+i+"  "+publicFields[i].getName()+
				" ("+publicFields[i].getType().getName()+")");

		}
	}

	public void printMethods()
	{
	}

	public static void main(String[] args) 
	{
		Button b = new Button();
		Integer int1 = new Integer (47);

		Class c = int1.getClass();
		Reference2 ref = new Reference2(c);
		ref.printAll();
		ref.printFields();

		System.out.println();
		Class d = b.getClass();
		ref = new Reference2(d);
		ref.printAll();
		
	}
}

