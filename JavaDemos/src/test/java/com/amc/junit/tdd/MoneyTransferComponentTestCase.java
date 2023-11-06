/**
 * This is a demo on TDD.
 * This test case is written first. Before the coding of the MoneyTransferComponet.
 * The test case is based on the design of the Money Transfer component.
 * 
 * Money Transfer Component does the following..
 * 1. checks whether the transfer is intra-bank or interbank
 * 2. invokes the necessary interface that transfer the money
 */
package com.amc.junit.tdd;

import com.amc.junit.base.IBankServices;
import com.amc.junit.base.Account;
import com.amc.junit.util.TestUtilities;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Amitava Chakraborty
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MoneyTransferComponentTestCase {

	private IBankServices bankServices;
	private Account fromAccount;
	private Account toAccount;

	
	@BeforeAll
	public void setUp(TestReporter testReporter)
	{
		bankServices = mock(IBankServices.class);
		fromAccount = TestUtilities.getRandomAccount();
		toAccount = TestUtilities.getRandomAccount();
		boolean fReturn = bankServices.transferAmount(
				fromAccount, toAccount, 500.00);
		testReporter.publishEntry("Mock Returns: "+fReturn);
		System.out.println("Mock Returns: "+fReturn);

		when(bankServices.transferAmount(
				fromAccount, toAccount, 500.00))
				.thenReturn(true);
	}
	
	@Test
	public void testMoneyTransfer()
	{
		assertEquals(true,
				bankServices.transferAmount(
						fromAccount, toAccount, 500.00));
	}
	
	
	
	
}
