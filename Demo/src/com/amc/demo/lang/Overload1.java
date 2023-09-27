package com.amc.demo.lang;
/** Example class showing the effects of ambiguous overload
 *  @see <A HREF="file://E:\Books\Java TechTips\20000314.htm#tip2">Techtips</A>
 *  @author : Amitava Chakraborty
 *  
 */
public class Overload1 extends Overload
{
	/** main method to run the class
	 *  to run the class issue the following command
	 *  $java Overload1
	 *  @param none
	 *  @return void
	 */
	public static void main(String[] args) 
	{
		Overload ovr = new Overload();

		System.out.println(ovr.getValue(55));
	}
}
