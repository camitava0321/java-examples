package com.amc.demo.gui;
// Demonstration of Stack Class.
import java.util.*;

public class Stacks
{

  public static void main(String[] args)
  {
    Stack stack = new Stack();                  /* Form a Stack */
    for(int i = 0; i < Month.month.length; i++) /* Enter Data in a Stack */
      stack.push(Month.month[i] + " ");
    System.out.println("stack = " + stack);     /* Print the entire stack */
    // Treating a stack as a Vector:
    stack.addElement("Last Item");          /* Add a new entry in the stack */
    System.out.println("8th Element : " +
      stack.elementAt(8));
    System.out.println("\npopping elements one by one:");
    while(!stack.empty())                       /* Popping a Stack */
      System.out.println(stack.pop());
  }
}

class Month
{
  public static String []month =
  {"January" , "February" , "March" , "April" , "May", "June" , "July" ,
   "August" , "September" , "October" ,"November" , "December"};
}