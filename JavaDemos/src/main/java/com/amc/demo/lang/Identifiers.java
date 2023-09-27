package com.amc.demo.lang;
public class Identifiers
{

    public static void main (String [] args)
    {

        //Following are valid java identifiers
        int java, lang , com,sun,javax;       /* Anything appears as part of */
                                              /* a package name              */
        int Runnable,Integer,Applet,          /* Any class name is a valid   */
            Object,Class;                     /* identifier                  */

        Thread Thread;                        /* Is perfectly valid          */

        int _any,$or,_And;                    /* Identifier can start with   */
                                              /* any valid ascii characters  */
                                              /* except the numbers          */
//      int bill,bill;                      /* ascii characters from 0x00- */
//      int bill,bill;                      /* 0x20 cannot be used as any  */
                                              /* part of the identifiers     */
//      int !bill,/bill;                      /* from 0x21-0x2F cannot be used*/
//      int b!ill,b/ill;                      /* as any part of an identifiers*/
//      int a-class;
//      int :bill,@bill;                      /* because these symbols has   */
//      int b:ill,b@ill;                      /* special meaning in java     */
                                              /* also true for 0x3A-0x40     */
//      int [bill,`bill;                      /* also true for 0x5B-0x60     */
//      int b[ill,b`ill;
//      int {bill,bill;                      /* also true for 0x7B-0x7F     */

        //Following are not valid identifiers
//      int 1NotAccepted;                     /* Identifiers cannot start with*/
//                                            /* numbers 0-9                 */
//      int goto;                             /* goto is a reserved word     */
//      int public,private;                   /* these are java keywords     */
//      int class,default;                    /* this is a java keyword      */

//      int com.sun.java;                     /* Whole package name is invalid*/
//      int any.anything;
//      int .anything;                        /* Period(.) cannot be used as */
//      int anything.;                        /* part of an identifier       */
//      int null,true,false;                  /* These are reserved literals */
        

    }
    
}
