package com.amc.demo.lang;
public class Shift
{




    public static void main (String [] args)
    {
        byte x = -1;
        int  y =  1;
        int  z =  1;

        x = (byte)(x >>> 25);
        y = y >>> 32;

        z = (z>0)?((y>0)?-z:z):((y>0)?-z:z);

        System.out.println("byte x : "+x+
            "   int  y: "+y);
    }
    
}
