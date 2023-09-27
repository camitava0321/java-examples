/**
 * 
 */
package com.amc.junit.base;

/**
 * @author Amitava Chakraborty
 *
 */
public class Account {
	
	private int accountId;
	private String accountName;
	private double balance;
	private String accountType;
	private double interestRate;
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String toString()
	{
		String string = getAccountName()+":"+getBalance()+":"+getInterestRate();
	return string;
	}
}
