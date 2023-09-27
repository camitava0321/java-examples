package com.amc.demo.lang;
/** A class that has all sort of possible(right, wrong, confused/ambiguous) 
overloaded methods.
 *  Description : class Overload describes to overloaded methods getMethod() and
 *  two more overloaded methods methodAmbiguous()

 *  @see <A HREF="file://E:\Books\Java TechTips\20000314.htm#tip2">Techtips 
March 14,2000 Tip 2</A>
 *  @author Amitava Chakraborty
 */
public class Overload
{
	/** Private variables
	 */
	private static int iValue1=1;	
	private static int iValue2=0;
    

	/** Valid Overloaded method 
   * @param float
	 * @return int (1)
	 */
	int getValue(float fValue)
	{
		System.out.println("Printing Float Value of : "+fValue);
    return (int)(iValue1*fValue);
	}
	
	/**Valid Overloaded method
   * @param double
	 * @return int (0)
	 */
	int getValue(double dValue)
	{
		System.out.println("Printing Double Value of : "+dValue);
		return (int)(iValue2*dValue);
	}
	
	/**Valid Overloaded Method
   * @param String
	 * @return int (-1)
	 */
	int getValue(String szValue)
	{
		System.out.println("Not supproted for Strings");
		return -1;
	}

  /**Invalid Overloaded Method : WILL NOT COMPILE
   * Only the access modifier is changed; 
   * To become a valid overloaded method atleast one of the parameters must be  
   * different
   * @param float
	 * @return int (-1)
	private int getValue(float fValue)
	{
		System.out.println("Not supproted for Strings");
		return -1;
	}
   */

  /**Invalid Overloaded Method : WILL NOT COMPILE 
   * Only the type modifier is changed; 
   * To become a valid overloaded method atleast one of the parameters must be  
   * different
   * @param float
	 * @return int (-1)
	private static int getValue(float fValue)
	{
		System.out.println("Not supproted for Strings");
		return -1;
	}
	 */

  /**Invalid Overloaded Method : WILL NOT COMPILE
   * Only the return type is changed; 
   * To become a valid overloaded method atleast one of the parameters must be  
   * different
   * @param float
	 * @return float (-1)
	float getValue(float fValue)
	{
		System.out.println("Not supproted for Strings");
		return -1;
	}	 
   */


	/**Although the following two methods are in certain cases ambiguous
   * the compiler will complain about the ambiguity only if the method
   * is called 
   * SO JUST DEFINING AMBIGUOUS METHOD WILL NOT CAUSE THE COMPILER TO FAIL
   * COMPILE WILL FAIL ONLY IF YOU CALL THE METHOD WITH THE AMBIGUITY
   *
   * @param float
	 * @return int (0)
	 */
	int ambiguousMethod(float fValue,double dValue)
	{
		System.out.println("Printing Float : "+fValue+" & Double : "+dValue);
		return 0;
	}

	/**@param float
	 * @return int (0)
	 */
	int ambiguousMethod(double dValue, float fValue)
	{
		System.out.println("Printing Double : "+dValue+" & Float : "+fValue);
		return 0;
	}

  /** The main method
   *
   *  @param String[]
   *  @return void
   */

  public static void main (String []args)
  {
    Overload ovl = new Overload();  // Get a new Instance of the class
    
    ovl.getValue(5.0);          // 5.0 will be treated as double
    ovl.getValue(5);            // 5 will be treated as float(default     
                                // promotion int->float)
    ovl.getValue(5f);           // 5f will be treated as float
    ovl.getValue("5");          // String parameter
    ovl.getValue((int)5);       // 5 will be casted to int and passed as double 
                                // parameter(default promotion int->double)
    ovl.getValue((long)(5f));   // 5f will be promoted to long 5 and will be 
                                // passed as a double parameter(default 
                                // promotion long->double) 

//    ovl.ambiguousMethod(5,6);   // Compiler will reject(ambiguous)
//    ovl.ambiguousMethod(
//      (float)5.0,6);            // Compiler will reject(ambiguous)  
//    ovl.ambiguousMethod(5,6f);  // Compiler will reject(ambiguous)
//    ovl.ambiguousMethod(5f,6f); // Compiler will reject(ambiguous)

  }

}
