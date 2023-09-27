package com.amc.demo.io;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This small program prints line numbers of a file it is fed into.
 * @author 109365
 *
 */
public class IOUtilities
{
/**
 * Utility method : types line numbers and the lines.
 * @param filename
 */
public static void typeLines(String filename)
{
	
String buffer=null;
long counter=0;
String szCounter="",temp="";
try
  {
  BufferedReader reader = new BufferedReader(
    new FileReader(filename));
  while((buffer=reader.readLine())!=null)
    {
    buffer=buffer.replace('\r',',');
    counter++;
    temp=String.valueOf(counter);
    for(int i=0;i<7-temp.length();i++)
      {
      szCounter=szCounter+" ";
      }
    szCounter=szCounter+temp+" -> ";
    System.out.println(szCounter+buffer);
    szCounter="";
    }
  }catch(Exception exc)
  {
  exc.printStackTrace();
  }
}

public static void main(String[] args) {
	IOUtilities.typeLines(args[0]);
}
}
