package com.amc.demo.lang;
public class Override
{

    
    public static void main (String [] args)
    {
    Byte b1 = new Byte("127");
    String a = b1.toString();
    String b = b1.toString();

     if(b1.toString() == b1.toString())
        System.out.println("True");
     else
        System.out.println("False");

     if(b1.toString().equals(b1.toString()))
        System.out.println("True");
     else
        System.out.println("False");

     if(a==b)
        System.out.println("True");
     else
        System.out.println("False");

    a = "127";
    b = "127";

     if(a==b)
        System.out.println("True");
     else
        System.out.println("False");

    a = new String("127");
    b = new String("127");

     if(a==b)
        System.out.println("True");
     else
        System.out.println("False");


    }
    
}

class OverrideTest
{

    static void method1()
    {
        System.out.println("method1 of OverrideTest");
    }

    void method2()
    {
        System.out.println("method2 of OverrideTest");
    }
}

class OverrideTest1 extends OverrideTest
{

    //Static methods cannot be overriden
//  void method1()
//  {
//      System.out.println("method1 of OverrideTest1");
//  }

    //Instance method cannot be overridden by static methods
//  static void method2()
//  {
//      System.out.println("method2 of OverrideTest1");
//  }

    
}
