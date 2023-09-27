package com.amc.demo.scjp.tests;
/*****************************************************************************/
/* QUESTION 6                                                                */
/*****************************************************************************/
/** What is the output ?

*/

    public class Test6
    {
        public static void main (String [] args)
        {

            int x = 5;                        /* 101                         */
            int b = 2;                        /* 010                         */
            x = x ^ (1<<b);

            System.out.println("b = "+ b + "\nx = " + x);
        }
    }
