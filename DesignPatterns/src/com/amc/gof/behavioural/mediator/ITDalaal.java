/**
 * 
 */
package com.amc.gof.behavioural.mediator;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class ITDalaal {

	String id;
	IncomeTaxDivision taxwala;
	
	public ITDalaal()
	{
		id="D001";
		taxwala=new IncomeTaxDivision();
	}
	
	
	
	public String consult()
	{
		return IncomeTaxDivision.itSubmitionProcess(); 
	}
	
	public String submitTaxReturn(String user, String docs)
	{
		return taxwala.acceptTaxReturn(user, this.id, docs);
	}
	
	public String getStatus()
	{
		return taxwala.getStatus();
	}
	
	public String getITReturn()
	{
		return taxwala.getItReturn();
	}
}
