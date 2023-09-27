/**
 * 
 */
package com.amc.gof.behavioural.mediator;

/**
 * @author Amitava Chakraborty
 * Nov 2, 2002 
 */
public class IncomeTaxDivision {

	private String user;
	private String userDocs;
	private String dalaal;
	private String status;
	private String ackReceipt;
	private String itReturn;
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	
	/**
	 * @return the userDocs
	 */
	public String getUserDocs() {
		return userDocs;
	}
	/**
	 * @param userDocs the userDocs to set
	 */
	public void setUserDocs(String userDocs) {
		this.userDocs = userDocs;
	}
	/**
	 * @return the dalaal
	 */
	public String getDalaal() {
		return dalaal;
	}
	/**
	 * @param dalaal the dalaal to set
	 */
	public void setDalaal(String dalaal) {
		this.dalaal = dalaal;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		String oldStatus=status;
		if (oldStatus.equals("Docs Received")) {
			setStatus("In Process");
		}
		if (oldStatus.equals("In Process")) {
			setStatus("Done");
			setItReturn("form 12C");
		}
		return oldStatus;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the ackReceipt
	 */
	public String getAckReceipt() {
		return ackReceipt;
	}
	/**
	 * @param ackReceipt the ackReceipt to set
	 */
	public void setAckReceipt(String ackReceipt) {
		this.ackReceipt = ackReceipt;
	}
	/**
	 * @return the itReturn
	 */
	public String getItReturn() {
		return itReturn;
	}
	/**
	 * @param itReturn the itReturn to set
	 */
	public void setItReturn(String itReturn) {
		this.itReturn = itReturn;
	}
	
	public static String itSubmitionProcess()
	{
		return "Submit docs A,B,C";
	}
	
	public String acceptTaxReturn(String user, String dalaal, String docs)
	{
		setUser(user);
		setDalaal(dalaal);
		setUserDocs(docs);
		setStatus("Docs Received");
		setAckReceipt("Receipt ID:ABC70012-XS-024");
		return getAckReceipt();
	}
	
}
