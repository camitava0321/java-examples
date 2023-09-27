package com.amc.demo.lang;
import java.io.*;
/** Example on Exceptions 
 */
public class ExceptionExample 
{
	

  
  
  
  
  
  public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}



class ExceptionExampleBase
{
  
//public ExceptionExampleBase() throws IOException
//{
//  throw new Exception();
//}

  public void aMethod() throws IOException
  {
    
    throw new IOException();
  }
};

class ExceptionExampleChild extends ExceptionExampleBase
{
  public ExceptionExampleChild()
  {
    
  }

  public void bMethod() throws IOException
  {
    new ExceptionExampleBase().aMethod();
  }
};
