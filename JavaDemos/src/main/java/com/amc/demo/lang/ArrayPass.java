package com.amc.demo.lang;
//Truearray.java


public class ArrayPass
{

    /** Inner class : It has a method checkElements() which checks for
     *  any duplication in the elements of an array passed to the class
     */
    class CheckArray
    {
    
        int [] thisArray;                     /* The array                   */

        /* Constructor of the inner class */
        CheckArray (int[] intArray)
        {
            thisArray = intArray;        
        }
    
        /** Checks the elements of an array
         *  If a duplicate item is found returns a false
         *  Otherwise returns a true
         *  @param None
         *  @return boolean true or false
         */
        public boolean checkElements()
        {
          int i,j;
          boolean fRet=true;
    
          for (i=0; i < thisArray.length; i++)
          {
              int prevalue = 0;
              prevalue = thisArray[i];
              for(j=i+1; j < thisArray.length; j++)
              {
                  if (prevalue == thisArray[j]) // Repetition found
                  {
                  fRet=false;
                  break;
                  }
              }
          }   
        return fRet;
        }
    
       
    }

    /** Creates an instance of the inner class CheckArray to check the elements of the array passed
     *  @param int[] array of integers
     *  @return boolean true if a repeated value is found in the array
     */
    public boolean checkArrayClass (int [] intArray)
    {
    CheckArray newArray = new CheckArray(intArray);
    return newArray.checkElements();
    }

/*****************************************************************************/
/* The main function                                                         */
/*****************************************************************************/
    public static void main(String[] args)
    {
        int intnumbers1[] = {2, 4, -6, 8, 7 };
        int intnumbers2[] = {2, 4, 6, 8, 7 };
        int intnumbers3[] = {2, 4, 8, 8, 7 };

        ArrayPass newArray = new ArrayPass();

        System.out.println("output value :" + newArray.checkArrayClass(intnumbers1) );
        System.out.println("output value :" + newArray.checkArrayClass(intnumbers2) );
        System.out.println("output value :" + newArray.checkArrayClass(intnumbers3) );
    }
}
