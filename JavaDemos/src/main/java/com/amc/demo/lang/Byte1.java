package com.amc.demo.lang;
public class Byte1
{

    public static void main (String [] args)
    {
        boolean fRetry=true;
        int sByteToBeUsed=1000;


        // How to create bytes

        //Invalid methods
        //Byte byte1 = new Byte(); //No such Constructor
        //Byte byte1 = new Byte(123);//Needed Cast Conversion
        Byte byte1 = new Byte((byte) 4200);
        Byte byte2 = new Byte(     //Eqv: new Byte(String)
            byte1.toString(        //.toString(byte) returns String
                byte1.byteValue()));//.byteValue returns a byte

        Byte byte3 = new Byte((byte)400);

        System.out.println(
            "Max Byte value Byte.MAX_VALUE : "+Byte.MAX_VALUE+"\n"+
            "Min Byte value Byte.MIN_VALUE : "+Byte.MIN_VALUE+"\n"+
            "The Primitive  Byte.TYPE      : "+Byte.TYPE     +"\n\n"
            );

        System.out.println(
            "Byte byte1 : "+byte1+"\n"+
            "Byte byte2 : "+byte2+"\n"+
            "Byte byte3 : "+byte3+"\n\n"
            );

        //What happens when 400 is added to this Byte byte2
        /* Even if a byte value of 400 is being added to the original one
         * only -112 will be added to 123, so the new byte2 object's value
         * will be 11 only
         */
        byte2 = new Byte ((byte)(byte2.byteValue()+(byte)400));


        System.out.println(
            "Byte byte1 : "+byte1+"\n"+
            "Byte byte2 : "+byte2+"\n\n"
            );

        //Different methods of a byte operated on object byte2
        System.out.println(
            "Byte.decode('127')           returns a new Byte object   : "+Byte.decode("127")+"\n"+
            "byte2.floatValue()           returns a float    value    : "+byte2.floatValue()+"\n"+
            "byte2.doubleValue()          returns a double   value    : "+byte2.doubleValue()+"\n"+
            "byte2.shortValue()           returns a short    value    : "+byte2.shortValue()+"\n"+
            "byte2.intValue()             returns a int      value    : "+byte2.intValue()+"\n"+
            "byte2.longValue()            returns a long     value    : "+byte2.longValue()+"\n"+
            "byte2.equals(new Byte((byte)123)) \n"+
            "                             returns a boolean  value    : "+
            byte2.equals(new Byte((byte)123))+"\n\n"
            );

        //Creating Byte objects from String objects : NumberformatException

        while(fRetry)
          {
          try {
  

          byte2 = new Byte (Byte.parseByte(Integer.toString(sByteToBeUsed)));

          System.out.println(
              "byte2.floatValue()           returns a float    value    : "+byte2.floatValue()+"\n"+
              "byte2.doubleValue()          returns a double   value    : "+byte2.doubleValue()+"\n"+
              "byte2.shortValue()           returns a short    value    : "+byte2.shortValue()+"\n"+
              "byte2.intValue()             returns a int      value    : "+byte2.intValue()+"\n"+
              "byte2.longValue()            returns a long     value    : "+byte2.longValue()+"\n"+
              "byte2.equals(new Byte((byte)100)) \n"+
              "                             returns a boolean  value    : "+
              byte2.equals(new Byte((byte)100))+"\n\n"
              );
          fRetry=false;
          }catch (NumberFormatException e)
          {
              System.out.println("NumberformatException occured for Integer ("+
                  sByteToBeUsed+")\nRetrying with Integer ("+
                  (sByteToBeUsed=(sByteToBeUsed-300))+")\n");
              fRetry=true;

          }catch (Exception e)
          {
              e.printStackTrace();
              fRetry=false;
          }
          }

    }
}
