/**
 * This class demonstrates the Mediator Pattern.
 * A class Gentleman needs to submit tax returns to another class IncomeTaxDivision.
 * It uses ITDalal to do so - who has the knowledge of the processes in IncomeTaxDivision.
 * ITDalaal implements the mediator pattern.
 * 
 */
package com.amc.gof.behavioural.mediator;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a Gentleman
		Gentleman gentleman = new Gentleman();
		//Create a ITDalaal who is consulted by the gentleman
		ITDalaal dalaal = new ITDalaal();
		
		//Step 1: What docs to submit - gentleman consults the dalaal
		System.out.println("What docs to submit ? "+gentleman.consultForTax(dalaal));
		
		//Step 2: Submit the documents to the dalaal
		System.out.println("Docs submitted to tax division; "+gentleman.submitTaxDocs("A,B,C", dalaal));
		
		//Step 3: Enquire Status of the return process through the dalaal
		System.out.println("What is status ? "+gentleman.inquireTaxReturnStatus(dalaal));
		
		//Step 3: Keep inquiring the Status of the return process through the dalaal until it is done
		System.out.println("What is status ? "+gentleman.inquireTaxReturnStatus(dalaal));
		//Step 3: Keep inquiring the Status of the return process through the dalaal until it is done
		System.out.println("What is status ? "+gentleman.inquireTaxReturnStatus(dalaal));
		
		//Step 4: Get the return 
		System.out.println("I got the IT-Return : "+gentleman.retriveTaxReturn(dalaal));
		
	}

}
