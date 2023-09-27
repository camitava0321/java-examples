/**
 * 
 */
package com.amc.demo.lang.enums;

/**
 * @author Amitava Chakraborty(ibm) - IT Architect IBM India
 * Aug 24, 2014 
 */
public class AMCEnum {
	DayOfWeek day;
	Planet planet;
	
    public static void main(String[] args) {

    	AMCEnum enumTest = new AMCEnum();
    	enumTest.DayOfWeekTest();
    	enumTest.PlanetTest();
    }

    public void PlanetTest()
    {
    	double earthWeight = 56.0; //My weight in Earth
        double mass = earthWeight/Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %f%n",
                             p, p.surfaceWeight(mass));
    }
	
    public void DayOfWeekTest()
    {
    	day = DayOfWeek.TUESDAY;
    /*
     * Compiler automatically adds some special methods when it creates an enum. 
     * For example, an enum has a static 'values' method that returns an array containing 
     * all of the values of the enum in the order they are declared. 
     * This method is commonly used in combination with the for-each construct to iterate 
     * over the values of an enum type.
     */
    	for (DayOfWeek d : DayOfWeek.values()) {
    	    System.out.printf("DayOfWeek is %s\n",
    	                      d);
    	}
      }

}