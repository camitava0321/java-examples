/* Conversion of Celsius Scale of Temperature to Farenheit and ViceVersa
 * Usage : java ConvTemp <C or F> <Value> 
 * Interpretaion : If a 'C' appears as first arg program interprets that the user wants a 
 *				   Celsius equivalent of the value provided; But if an 'F' appears as the
 *				   first arg program interprets that a Farenheit equivalent of the value
 *				   provided with is requested
 * 

 * Class ConvTemp and Class Temperature is written in the same source code because they
 * are not defined as public, rather since nothing has been specified they are treated 
 * as of protected type and may be accessible from anywhere within the package, if any

 * Author : Amitava Chakraborty
 * Ver 1.0:
 *	Limitations :	Cannot handle floating point inputs
 *					Cannot handle exceptions
*/

package com.amc.demo.util;


public class convtemp
{

	public static void main(String [] args)	
	{
    char scale=' ';
    float value=0.0F;
    Temperature temp;                         /* Temperature object          */

        try
        {
            scale = args[0].charAt(0);        /* get the scale the value is  */
                                              /* required in                 */
            value = new Float(args[1]).       /* get the value               */
                       floatValue();


            temp = new Temperature(value);    /* create Temperature object   */
        
        	if (scale=='C')
        		{
        		System.out.println("Input   : " + temp + " F");
        		System.out.println("Celsius : "+ temp.ToCelsius() + " C");
        		}
        	else
        		{
        		System.out.println("Input   : " + temp + " C");
        		System.out.print("Farenheit : "+ temp.ToFarenheit() + " F");
        		}
        }catch(Exception e)                   /* Any exception occurs        */
        {
            e.printStackTrace();              /* pint stack                  */
            printUsage();                     /* print usage                 */
        }
	}


    /** Prints usage on occurrence of any exception/error
     */
    public static void printUsage()
    {
        System.out.println("Usage: convtemp <option> <value>");
        System.out.println("The valid options are ");
        System.out.println("C if the value is wanted in Celsius");
        System.out.println("F if the value is wanted in Farenheit");
    }
}

