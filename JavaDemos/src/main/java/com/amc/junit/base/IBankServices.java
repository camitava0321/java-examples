/**
 * 
 */
package com.amc.junit.base;

/**
 * @author ibm
 *
 */
public interface IBankServices {
	
	public boolean transferAmount(Account fromAccount, Account toAccount, double amount) throws BankServicesException;

}
