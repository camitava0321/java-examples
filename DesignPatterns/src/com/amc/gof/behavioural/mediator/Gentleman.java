/**
 * 
 */
package com.amc.gof.behavioural.mediator;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class Gentleman {

	String id;
	public Gentleman()
	{
		id="U001";
	}
	/**
	 * @return
	 */
	public String consultForTax(ITDalaal dalaal) {
		return dalaal.consult();
	}

	/**
	 * @param string
	 * @return
	 */
	public String submitTaxDocs(String docs, ITDalaal dalaal) {
		return dalaal.submitTaxReturn(this.id, docs);
	}
	/**
	 * @param dalaal
	 * @return
	 */
	public String inquireTaxReturnStatus(ITDalaal dalaal) {
		return dalaal.getStatus();
	}
	/**
	 * @param dalaal
	 * @return
	 */
	public String retriveTaxReturn(ITDalaal dalaal) {
		return dalaal.getITReturn();
	}

}
