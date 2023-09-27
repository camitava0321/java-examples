package com.amc.demo.gui;
/** Test1.java
 *  Does the following java program compile and run
 * If not what is the problem ?

 */

    public class Test1
    {

        public static void main(String [] args)
        {
            char a = 'A';
            char A = 'a';
            int i = (int) a;
            int j = (int) A;
            int z = i + j;

            System.out.println("z = " + z);
        }
    }

/*****************************************************************************/
/* ANSWER                                                                    */
/*****************************************************************************/
/* Answer : Works 100% */
