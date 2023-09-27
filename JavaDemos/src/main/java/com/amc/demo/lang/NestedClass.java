package com.amc.demo.lang;
/** An Example of Nested Class

    
    @author Amitava Chakraborty
    @version 1.0.0
 */
public class NestedClass
{
/*****************************************************************************/
/* Instance Variables                                                        */
/*****************************************************************************/
public int publicVar;
int friendlyVar;
protected int protectedVar;
private int privateVar;

public final int publicFinalVar=1;
final int friendlyFinalVar=2;
protected final int protectedFinalVar=3;
private final int privateFinalVar=4;

/*****************************************************************************/
/* Class Variables                                                           */
/*****************************************************************************/
static public int staticPublicVar;
static int staticFriendlyVar;
static protected int staticProtectedVar;
static private int staticPrivateVar;

static public final int staticPublicFinalVar=3;
static final int staticFriendlyFinalVar=2;
static protected final int staticProtectedFinalVar=3;
static private final int staticPrivateFinalVar=4;


/*****************************************************************************/
/* Constructors                                                              */
/*****************************************************************************/
    public NestedClass(int i)
    {
    publicVar=staticPublicVar;
    }

    public void instanceMethod()
    {
    privateVar++;
    }

    public static void staticMethod()
    {
    }


/*****************************************************************************/
/* Nested Class                                                              */
/*****************************************************************************/
    static class Nest
    {
        /* A static nested class can */
        /* Instantiate its Wrapping class */
        NestedClass n1 = new NestedClass(staticPublicFinalVar);

        /* Can have private methods */
        /* which the wrapping class may access */
        private void NestedMethod(int x)
        {
        /* Can reference any instance variable of the wrapping class */
        /* as long as an object reference is there */
        /* so the following line if uncommented */
        //instanceMethod();
        /* will not compile */
        n1.instanceMethod();

        /* can reference any static method of the wrapping class */
        /* with or without the object reference */
        staticMethod();
        n1.staticMethod();
        }

    }

/*****************************************************************************/
/* Inner Class                                                               */
/*****************************************************************************/
    class Inner
    {
    }

/*****************************************************************************/
/* Anonymous Class                                                           */
/*****************************************************************************/


/*****************************************************************************/
/* The main method                                                           */
/*****************************************************************************/

    public static void main (String [] args)
    {
        Nest n1 = new Nest();                 /* Creating an instance of the */
                                              /* static nested class         */
//      n1.NestedMethod(A1);                  /* Accessing a private method  */
                                              /* of the nested class         */
    }
    
}
