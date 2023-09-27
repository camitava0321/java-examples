/*****************************************************************************/
/* The biggest decimal number that this program can hndle is                 */
/* 18446699999999999999                                                      */
/*****************************************************************************/
package com.amc.demo.util;

import com.amc.datatype.Binary;

public class BinUtils
{
private static final short ERR_USAGE     =0x101;
private static final short ERR_SHIFTTYPE =0x201;
private static final short ERR_SHIFTWIDTH=0x202;

  public static void main(String [] args)
  {
    double dValue=0.0;
    byte bValue;
    short sValue;
    int iValue;

    boolean fCalculateShift=true;
    short sShiftWidth=0;
    char  chShiftType='R';
    char  chShiftSign='-';

    Binary bin = null;
    Binary resultBin = null;

  
    try
    {
      dValue = Double.valueOf(args[0]).doubleValue();
      if (args.length>2)
      {
        chShiftType=args[1].charAt(0);
        switch(chShiftType)
        {
          case 'R':
            chShiftSign='+';
            if (args[1].length()>1)
              {
              chShiftSign=args[1].charAt(1);
              if (chShiftSign!='-')
                {
                chShiftSign='+';
                }
              }
            break;
          case 'L':
            chShiftSign='+';
            break;
          default :
            displayError(ERR_SHIFTTYPE);
            fCalculateShift=false;
            break;
        }
        sShiftWidth = Short.valueOf(args[2]).shortValue();
        if (sShiftWidth > 64 || sShiftWidth < 0)
        {
          displayError(ERR_SHIFTWIDTH);
          fCalculateShift=false;
        }
      }
      else
      {
        fCalculateShift=false;
      }
  
      if (dValue <= Byte.MAX_VALUE &&
          dValue >= Byte.MIN_VALUE)
      {
        bValue = (byte)dValue;
        bin = new Binary(bValue);
      }
      else if (dValue <= Short.MAX_VALUE &&
               dValue >= Short.MIN_VALUE)
      {
        sValue = (short)dValue;
        bin = new Binary(sValue);
      }
      else if (dValue <= Integer.MAX_VALUE &&
               dValue >= Integer.MIN_VALUE)
      {
        iValue = (int)dValue;
        bin = new Binary(iValue);
      }
      else
      {
        bin = new Binary(dValue);
      }

    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      displayError(ERR_USAGE);
    }
    catch(Exception e)
    {
      displayError(ERR_USAGE);
    }
  
    System.out.println(bin.getBinaryValue() +
        "(" + bin.getBinarySize() +") : " +
        bin);

    if (fCalculateShift)
    {
      if (chShiftType=='R' && chShiftSign=='-')
      {
      resultBin = bin.shiftRightSigned(sShiftWidth);
      }
      else if (chShiftType=='R' && chShiftSign=='+')
      {
      resultBin = bin.shiftRightUnSigned(sShiftWidth);
      }
      else if (chShiftType=='L')
      {
      resultBin = bin.shiftLeft(sShiftWidth);
      }

    System.out.println(resultBin.getBinaryValue() +
        "(" + resultBin.getBinarySize() +") : " +
        resultBin);
    }
  
  /*****************************************************************************/
  /* Example how to use Binary class to print binary data without the need of  */
  /* instantiation of a Binary Class                                           */
  /*****************************************************************************/
  //System.out.println(Binary.getBinary(dValue*2));
  }

  public static void displayError (short sError)
  {

    System.out.print("Error : "+sError+" ");
    switch(sError)
    {
      case ERR_USAGE:
        System.out.println("Usage : BinUtils <int_value>");
        System.out.println("OR      BinUtils <int_value> "+
           "<shift_type(R | R- |L)> "+
           "<shift_value(between 0 and 64)>");
        break;

      case ERR_SHIFTTYPE:
        System.out.println("Invalid Shift Operartor");
        System.out.println("Valid Operators are :");
        System.out.println("R or R+ - unsigned right shift");
        System.out.println("R-      - signed   right shift");
        System.out.println("L       - signed   left  shift");
        break;

      case ERR_SHIFTWIDTH:
        System.out.println("Invalid Shift Width");
        System.out.println("Enter a number between 0 and 64");
        break;
    }

  System.exit(0);
  }
}
