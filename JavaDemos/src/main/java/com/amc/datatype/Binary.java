/** The Class Provides a Binary Object and the functionalities of the object
 *  The Class may be instantiated and may be subclassed
 *  Following are the methods and the description of the method supplied
 *  Method Name -                     Description
 *
 *
 *
 *
 *  @author : Amitava Chakraborty
 *  @version  1.0.0
 */

package com.amc.datatype;

public class Binary {

/*****************************************************************************/
/* Private Final Data                                                        */
/*****************************************************************************/
private static final int DEFAULT_SIZE=64;     /* Default Size of Binary Object*/
private static final int     BIT_SIZE=1;      /* Bit Size Binary Object      */
private static final int    BYTE_SIZE=8;      /* Byte Sized Binary Object    */
private static final int   SHORT_SIZE=16;     /* Short Sized Binary Object   */
private static final int     INT_SIZE=32;     /* Int Sized Binary Object     */
private static final int    LONG_SIZE=64;     /* Long Sized Binary Object    */

/*****************************************************************************/
/* Private Instance Variables                                                */
/*****************************************************************************/
private StringBuffer sbBinary =               /* Keeps the Binary data       */
      new StringBuffer(DEFAULT_SIZE);         /* in this Buffer              */

private String szBinaryData;                  /* Temp Buffer for the Binary  */
                                              /* Data                        */
private double dRequestedValue;               /* Copy of Original Value Req  */
                                              /* in the form of a double     */
private int sSize;                            /* Size of the Binary String   */

/*****************************************************************************/
/* Constructors                                                              */
/*****************************************************************************/
    /** Constructor : No Parameter
     *  Private Constructor
     *  This is provided if anybody needs an all zero 64bit binary
     *  Since no real need is felt yet for this kind of a Constructor from the
     *  user's point of view (however in this class this constructor is used)
     *  No operator method is provided yet
     *  So user of this class cannot use the following way to instantiate a
     *  Binary Object
     *  Binary bin = new Binary();  // will get a compilation error
     */
    private Binary()
    {
    sSize = DEFAULT_SIZE;
    dRequestedValue=0;
    sbBinary.setLength(0);
    szBinaryData = sbBinary.toString();
    }

    /** Following are the overloaded constructor set that creates a binary obj
     *  with the value supplied, by the user.
     *  Note : irrespective of the type of constructor is called the binary obj
     *         is created by casting the value into a double first; so no data
     *         loss may appear; however the user may call the constructor eg.
     *         Binary bin = new Binary(aValue) , where aValue is a short and
     *         aValue may have been assigned as
     *         aValue = (short)lValue , where lValue is a long
     *         then already data loss has happened in the assignment
     *         During Binary object creation no data loss can happen
     */
    /** Constructor : parameter byte
     *  Create a Binary object with a byte value
     */
    public Binary(byte bValue)
    {
      this();                                 /* Do the initialisations      */
                                              /* using private constructor   */

      sSize = BYTE_SIZE;                      /* Size is 8 bit               */
      dRequestedValue = bValue;               /* Automatic promotion         */

      prepareBinary();                        /* private static method       */

    }

    /** Constructor : parameter short
     *
     */
    public Binary(short sValue)
    {
      this();                                 /* Do the initialisations      */
                                              /* using private constructor   */

      sSize =SHORT_SIZE;                      /* Size is 16 bit              */
      dRequestedValue = sValue;               /* Automatic promotion         */

      prepareBinary();                        /* private static method       */

    }

    /** Constructor : parameter int
     *
     */
    public Binary(int iValue)
    {
      this();                                 /* Do the initialisations      */
                                              /* using private constructor   */

      sSize =  INT_SIZE;                      /* Size is 32 bit              */
      dRequestedValue = iValue;               /* Automatic promotion         */

      prepareBinary();                        /* private static method       */

    }

    /** Constructor : parameter double
     *
     */
    public Binary(double dValue)
    {
      this();                                 /* Do the initialisations      */
                                              /* using private constructor   */

      sSize = LONG_SIZE;                      /* Size is 64 bit              */
      dRequestedValue = dValue;               /* Automatic promotion         */

      prepareBinary();                        /* private static method       */

    }

/*****************************************************************************/
/* Private Methods                                                           */
/*****************************************************************************/
    /** Performs preparation of the string in the form of a stream of 1s and 0s
     *  representing the numeric value, and stores the string according to the
     *  size requested in a String object
     */
    private void prepareBinary()
    {

      int sLength=0;
      double dResult=0.0;

      dResult = Math.abs(this.dRequestedValue);/* Absolute Value              */
      dResult = Math.floor(dResult);          /* Floor Value                 */

      while(dResult >=2)
      {
        dResult = dResult / 2;
        if (dResult>Math.floor(dResult))
        {
          sbBinary.append("1");
        }
        else
        {
          sbBinary.append("0");
        }
        dResult = Math.floor(dResult);
         
      }
      this.sbBinary.append(Double.toString(Math.floor(dResult)).charAt(0));

      sLength = DEFAULT_SIZE-this.sbBinary.length();
      while (sLength!=0)
      {
        this.sbBinary.append("0");        
        sLength--;
      }

      this.sbBinary.reverse();

      /* Check for Negative Bit */
      if (this.dRequestedValue < 0)           /* Negative Value              */
      {                                       /* Set the Most Significant    */
        this.sbBinary.setCharAt(              /* Bit(MSB) to true('1')       */
            DEFAULT_SIZE-sSize,'1');                        
      }
      this.szBinaryData = (this.sbBinary.toString()).substring((DEFAULT_SIZE-sSize));

    }

    /** Creates and returns a Binary object from the double value according to the
     *  size requested.          
     */
    private Binary getBinaryWithSize(double dValue,int sSize)
    {
      Binary bin=null;

      sSize = validateCast(dValue);

      switch(sSize)
      {
      case BIT_SIZE:
        // not implemented yet
        break;
      case BYTE_SIZE:
        bin = new Binary((byte)dValue);
        break;
      case SHORT_SIZE:
        bin = new Binary((short)dValue);
        break;
      case INT_SIZE:
        bin = new Binary((int)dValue);
        break;
      case LONG_SIZE:
      default:
        bin = new Binary(dValue);
        break;
      }

    return bin;
    }

    /** Returns a valid size of a number based on its value range
     *  Accepts a double as the parameter
     */
    private static int validateCast(double dValue)
    {
      int sSize=DEFAULT_SIZE;

      if (dValue <= Byte.MAX_VALUE &&
          dValue >= Byte.MIN_VALUE)
      {
        sSize = BYTE_SIZE;
      }
      else if (dValue <= Short.MAX_VALUE &&
               dValue >= Short.MIN_VALUE)
      {
        sSize = SHORT_SIZE;
      }
      else if (dValue <= Integer.MAX_VALUE &&
               dValue >= Integer.MIN_VALUE)
      {
        sSize = INT_SIZE;  
      }

    return sSize;
    }

/*****************************************************************************/
/* Public Methods                                                            */
/*****************************************************************************/
    /** Returns a Binary Object , bit-pattern will be of 64bit irrespective of
     *  the size of the number
     */
    public static Binary getBinary(double dValue)
    {
    return new Binary(dValue);
    }

    /** Returns the value of a Binary Object in double
     *  Accessor method of private instance variable dRequestedValue
     */
    public double getBinaryValue()
    {
    return this.dRequestedValue;
    }

    /** Returns the size of a Binary Object in int   
     *  Accessor method of private instance variable sSize
     */
    public int getBinarySize()
    {
    return this.sSize;
    }

    /** Binary & Operations
     */
    public Binary and(Binary bin)
    {
    double dResult;

    dResult = (long)this.dRequestedValue &
              (long)bin.dRequestedValue;

    return getBinaryWithSize(dResult, this.sSize);
    }

    /** Binary | Operations
     */
    public Binary or(Binary bin)
    {
    double dResult;

    dResult = (long)this.dRequestedValue |
              (long)bin.dRequestedValue;

    return getBinaryWithSize(dResult, this.sSize);
    }

    /** Binary ~ Operations
     */
    public Binary complement()
    {
    double dResult;

    dResult = ~(long)(this.dRequestedValue);

    return getBinaryWithSize(dResult, this.sSize);
    }

    public Binary shiftRightSigned(int sShiftWidth)
    {
    double dResult;

    dResult = (long)this.dRequestedValue >> sShiftWidth;

    return getBinaryWithSize(dResult,this.sSize);
    }

    public Binary shiftRightUnSigned(int sShiftWidth)
    {
    double dResult;

    dResult = (long)this.dRequestedValue >>> sShiftWidth;

    return getBinaryWithSize(dResult,this.sSize);
    }

    public Binary shiftLeft(int sShiftWidth)
    {
    double dResult;

    dResult = (long)this.dRequestedValue << sShiftWidth;

    System.out.println(dResult);
    return getBinaryWithSize(dResult,this.sSize);
    }

/*****************************************************************************/
/* Overriden Methods                                                         */
/*****************************************************************************/
    public String toString()
    {
      return this.szBinaryData;
    }

    public boolean equals (Object obj)
    {
    boolean fReturn = false;
    Binary binCompare = new Binary();

      if (obj instanceof Binary)
      {
        binCompare = (Binary)obj;
        if (binCompare.szBinaryData.equals(this.szBinaryData))
        {
          fReturn = true;
        }
      }

    return fReturn;
    }

}
