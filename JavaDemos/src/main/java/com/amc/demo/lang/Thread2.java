package com.amc.demo.lang;
class Thread2  
{
	public static void main(String[] args) 
	{
		String [] szNames={"Jenny","John","Rustam"};

		Monitor monitor = new Monitor(3,szNames);
 
		monitor.start();
	}
}

class Person extends Thread
{
	private String szPersonName;
	private boolean fAwake;
	private int sSleep;

	Person (String szName){
		szPersonName=szName;
		fAwake=true;
		sSleep=1000;
	}
	
	public void run()
	{
		while(true)
		{
			try{
				sleep(sSleep);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			fAwake=!fAwake;
			if (sSleep > 3000)
			{
				sSleep=1000;
			}
			else
			{
				sSleep=sSleep+1000;
			}
		}
	}
	
	public String toString()
	{
		return szPersonName;
	}
	
	public boolean ifAwake()
	{
		return fAwake;
	}
};

class Monitor extends Thread
{
	public static String szName;	
	public static int sPersons=0;
	public static Person [] persons;

	Monitor (int sNoPersons, String []szNames)
	{
		sPersons=sNoPersons;
		persons = new Person[sPersons];

		for (int i=0; i<sPersons ;i++ )
		{
			persons[i] = new Person(szNames[i]);
			persons[i].start();
		}
	}
	
	public void run()
	{
		while(true)
		{
			for (int i=0;i<sPersons ;i++ )
			{
				System.out.println(persons[i]+" is "+
					( (persons[i].ifAwake())?" Awake":" Sleeping")
					);
			}
			try{
				sleep(1000);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
};

