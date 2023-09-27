package com.amc.demo.scjp.tests;
/*****************************************************************************/
/* QUESTION 3                                                                */
/*****************************************************************************/
/** Is there a problem with the following code?

    public class Test3
    {
        public static void main (String [] args)
        {
            Double d1 = new Double (3.1);
            Double d2 = new Double(4.1);
            Double R = d1.add(d2);

            System.out.println("R = " + R);
        }
    }


*/    

/*****************************************************************************/
/* ANSWER                                                                    */
/*****************************************************************************/
/** Double R = d1.add(d2) - method add does not exists in Double class
 *  One cannot add objects like that
 * solution is provided below
 */


    public class Test3
    {
        public static void main (String [] args)
        {
            Double d1 = new Double (3.1);
            Double d2 = new Double(4.1);
            Double R = new Double(
                d1.doubleValue() +
                d2.doubleValue());

            System.out.println("R = " + R);

        }
    }



