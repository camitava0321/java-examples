package com.amc.demo.lang;
public class Boolean1
{

    public static void main (String [] args)
    {
        // Boolean.TRUE = false // Compile error : because TRUE for Boolean Object is declared final

        //Ways to create a Boolean Object
//      Boolean boolean1 = new Boolean ();  // Compile error :
                                            // There is no such constructor for Boolean
//      Boolean boolean1 = new Boolean (1); // Compile error:
                                            // No such Constructor Boolean(int)

        //Not even in the following ways one can avoid the compile error
        //because value 1 (both int and String) cannot be casted to a boolean
//      Boolean boolean1 = new Boolean ((boolean)1); 
//      Boolean boolean1 = new Boolean ((boolean)"1");
        //Even the following cast is invalid
        //because a String cannot be casted into a boolean
//      Boolean boolean1 = new Boolean ((boolean)"true");

        //The valid ways 
        Boolean boolean1 = new Boolean (true);
        Boolean boolean2 = new Boolean ("1");   //Since the String is other than "true"
                                                //the value of the object will be false
        Boolean boolean3 = new Boolean ("TRUE");//CAPS on     - the value is true
        Boolean boolean4 = new Boolean ("true");//CAPS    off - the value is true
        Boolean boolean5 = new Boolean ("false");//CAPS on     - the value is false 
        Boolean boolean6 = new Boolean ("FALSE");//CAPS    off - the value is false 

        //Some other ways involving static methods
        Boolean boolean7 = Boolean.valueOf("TRUE");//.valueOf(String) returns a new Boolean Object
                                                   //case is ignored

        Boolean boolean8 = new Boolean (           // eqv to new Boolean(boolean)
            Boolean.getBoolean(                    //.getBoolean(String) returns a boolean primitive
                boolean2.toString()));             //.toString() returns a String

        Boolean boolean9 = new Boolean (boolean1.booleanValue());
                                                   //.booleanValue() returns a boolean primitive

        System.out.println("Boolean.TRUE : "+Boolean.TRUE+"\n"+
                           "Boolean.FALSE: "+Boolean.FALSE+"\n"+
                           "Boolean.TYPE : "+Boolean.TYPE+"\n\n");

        System.out.println("Object boolean1 : "+boolean1+"\n"+
                           "Object boolean2 : "+boolean2+"\n"+
                           "Object boolean3 : "+boolean3+"\n"+
                           "Object boolean4 : "+boolean4+"\n"+
                           "Object boolean5 : "+boolean5+"\n"+
                           "Object boolean6 : "+boolean6+"\n"+
                           "Object boolean7 : "+boolean7+"\n"+
                           "Object boolean8 : "+boolean8+"\n"+
                           "Object boolean9 : "+boolean9+"\n"
                          );
    }
}
