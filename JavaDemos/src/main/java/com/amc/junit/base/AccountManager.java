/**
 * 
 */
package com.amc.junit.base;

/**
 * @author Amitava Chakraborty
 *
 */
public class AccountManager {

	public static final double MIN_INTEREST_RATE=4.00;
	public static final double BASIC_INTEREST_RATE=5.00;
	public static final double BASIC_CURRENT_INTEREST_RATE=8.00;
	public static final double MAX_INTEREST_RATE=BASIC_CURRENT_INTEREST_RATE*(1.2);
	
	
	public void setInterestRate(Account account)
	{
		if (account.getAccountType().equals("SAVINGS")) {
			setInterestRateForSavings(account);
		}
		if (account.getAccountType().equals("CURRENT")) {
			setInterestRateForCurrent(account);
		}
	}
	
	public void setInterestRateForSavings(Account account)
	{
		if (account.getBalance()<1000) {
			account.setInterestRate(MIN_INTEREST_RATE);
		}
		if (account.getBalance()>1000) {
			account.setInterestRate(BASIC_INTEREST_RATE);
		}
	}
	
	public void setInterestRateForCurrent(Account account)
	{
		if (account.getBalance()<10000) {
			account.setInterestRate(BASIC_CURRENT_INTEREST_RATE);
		}
		if (account.getBalance()>10000) {
			account.setInterestRate(MAX_INTEREST_RATE);
		}
	}
}