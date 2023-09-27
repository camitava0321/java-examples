package com.amc.demo.lang;
/** How many objects can you create before JVM crashes !!
 */
public class mem
{

public static void main (String [] args)
{

    while(true)                               /* creates a new object of unit*/
    {                                         /* forever                     */
        unit unit = new unit();
        System.out.println(unit);
    }
}

}

/** An arbitrary class
 */
class unit
{
static int i=0;
String data="";

public unit()
{
    i++;
    data="Anything - "+i;
}

public String toString()
{
    return data;
}

}
