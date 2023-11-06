/**
 * Demo: Parameterized Test Case
 * 
 */
package com.amc.junit.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.amc.junit.base.Account;
import com.amc.junit.base.AccountManager;

/**
 * @author Amitava Chakraborty
 * 
 * This '@RunWith(Parameterized.class)' enables the test runner (a runner class or eclipse) 
 * to run this test case using parameters. The parameters are defined in a 'public static' 
 * method that uses @Parameterized.Parameters annotation
 *
 */
@RunWith(Parameterized.class)
public class AccountManagerTestCase {

	private Account account=null;
	private AccountManager accountManager=null;
	
	private double expectedTestResult=0;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//SetUp several Test Accounts
		account = new Account(1000, "Account name1",900,"SAVINGS",0);
		accountManager = new AccountManager();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Clear Test Accounts
		account = null;
		accountManager=null;
	}

	/**
	 * Test method for {@link com.amc.junit.base.AccountManager#setInterestRate(com.amc.junit.base.Account)}.
	 */
	@Test
	public void testSetInterestRate(Account account) {
		
		expectedTestResult=AccountManager.MIN_INTEREST_RATE;
		accountManager.setInterestRate(account);
		
		//delta is 0.0
		assertEquals(expectedTestResult, account.interestRate(), 0.0);
		assertTrue(expectedTestResult< account.interestRate());
		System.out.println(account);
	}
	
	@Parameterized.Parameters
	public static Collection accounts()
	{
	ArrayList<Account> accounts = new ArrayList<Account>(5);
	for (int i = 0; i < accounts.size(); i++) {
		accounts.add(setupAccountObject(i));
	}
	return(accounts);
	}
	
	private static Account setupAccountObject(int seed)
	{
		Account account = null;
		account = new Account(1000+seed, "Account name"+seed,
				900+10000*(seed*Math.random()),
				((seed%2)!=0)?"SAVINGS":"CURRENT",
				0);
		return(account);
	}
}