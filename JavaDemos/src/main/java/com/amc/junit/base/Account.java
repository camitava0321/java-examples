/**
 * 
 */
package com.amc.junit.base;

import java.util.Objects;

/**
 * @author Amitava Chakraborty
 *
 */
public record Account (
		int accountId,
		String accountName,
		double balance,
		String accountType,
		double interestRate

) {
	public static double DEFAULT_BALANCE=0.0;
	public static double DEFAULT_INTEREST_RATE=AccountManager.BASIC_INTEREST_RATE;
	public Account {
		Objects.requireNonNull(accountId,"Account Id cannot be null");
		Objects.requireNonNull(accountName,"Account Name cannot be null");
		Objects.requireNonNull(accountType,"Account Type cannot be null");
	}

	//Custom Constructor
	public Account (int accountId, String accountName, String accountType) {
		this(accountId,accountName,DEFAULT_BALANCE,accountType,DEFAULT_INTEREST_RATE);
	}
}
