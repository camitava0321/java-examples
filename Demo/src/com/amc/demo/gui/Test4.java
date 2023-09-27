package com.amc.demo.gui;
/*****************************************************************************/
/* QUESTION 4                                                                */
/*****************************************************************************/
/** What is the output of the following program ?

*/

    public class Test4
    {
        public static void main (String [] args)
        {
            int i = 8;
            int [] a = new int[2];
            a[0] = 4; a[1] = 8;
            String str = new String("27");

            surprise(i,a,str);

            System.out.println("i = "+ i++);  /* 8                           */
            /* i will be 8 even if it is made 16 inside surprise, because
             * among the three parameters only i is passed by value and hence
             * computed locally, the array and the String being objects are
             * passed by reference */

            System.out.println("a[0] = " + a[0]);    /* 43                   */
            System.out.println("a[1] = " + a[1]);    /* 51                   */
        }

        static void surprise(int i, int [] a, String str)
        {
            int j = Integer.valueOf(str).
                intValue();                   /* j=27                        */
            int result = i + a[0] + j;        /* result = 8+4+27 = 39        */

            i = i+i;                          /* i = 16                      */

            a[0] = a[0] + result;             /* a[0] = 4 + 39 = 43          */
            a[1] = a[1] + a[0];               /* a[1] = 8 + 43 = 51          */

        }
    }
