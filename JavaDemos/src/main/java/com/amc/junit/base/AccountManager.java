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
	
	
	public Account setInterestRate(Account account)
	{
		Account newAccount = null;
		if (account.accountType().equals("SAVINGS")) {
			newAccount = setInterestRateForSavings(account);
		}
		if (account.accountType().equals("CURRENT")) {
			newAccount = setInterestRateForCurrent(account);
		}
	return(newAccount);
	}
	
	public Account setInterestRateForSavings(Account account)
	{
		Account newAccount = null;
		if (account.balance()<1000) {
			newAccount = new Account(account.accountId(),account.accountName(),account.balance(), account.accountType(),
					MIN_INTEREST_RATE);
		}
		if (account.balance()>1000) {
			newAccount = new Account(account.accountId(),account.accountName(),account.balance(), account.accountType(),
					BASIC_INTEREST_RATE);
		}
		return(newAccount);
	}
	
	public Account setInterestRateForCurrent(Account account)
	{
		Account newAccount = null;
		if (account.balance()<10000) {
			newAccount = new Account(account.accountId(),account.accountName(),account.balance(), account.accountType(),
					BASIC_CURRENT_INTEREST_RATE);
		}
		if (account.balance()>10000) {
			newAccount = new Account(account.accountId(),account.accountName(),account.balance(), account.accountType(),
					MAX_INTEREST_RATE);
		}
		return(newAccount);
	}

	public Account cloneAccount(Account account) {
		return new Account(account.accountId(),account.accountName(),account.balance(), account.accountType(), account.interestRate());
	}
}