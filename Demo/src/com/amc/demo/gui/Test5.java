package com.amc.demo.gui;
/*****************************************************************************/
/* QUESTION 5                                                                */
/*****************************************************************************/
/** What is the output ?

*/

    public class Test5
    {

        public static void main (String [] args)
        {
            boolean b = false;
            b = !b;                           /* b = true                    */
            b = !b;                           /* b = false                   */
            System.out.println("b = " + b);   /* b = false                   */

            boolean c;
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);

            if(x == y)
                c = true;
            else
                c=false;

            System.out.println("c = " + c);   /* false most of the time      */
        }
    }
