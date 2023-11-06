package com.amc.junit.base;

import com.amc.junit.util.TestUtilities;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountTestCase {

  private Account account;

  @BeforeAll
  public void init() {
    account = TestUtilities.getRandomAccount();
  }

  @AfterAll
  public void teardown() {
    account=null;
  }
  // Did We receive public getters methods, whose names match the name of our field?
  @Test
  @DisplayName("Whether Getters are generated?")
    public void testGeneratedGettersForRecord() {
        assertNotNull(account.accountName(), () -> {return "Null Account Object";});
        assertTrue(account.balance() >= 1000.0, ()-> {return "Account Balance is less than 1000.00";});
    }

  //Did we receive an equals method generated for us?
  //This method returns true if the supplied object is of the same type and the values of all of its fields match:
  @Test
  @DisplayName("Whether Equals method is generated?")
  public void testGeneratedEqualsMethodforRecord() {

    Account account2 = TestUtilities.getRandomAccount();
    Account account3 = new AccountManager().cloneAccount(account);
      assertNotEquals(account, account2);
      assertEquals(account, account3);
  }

  //Did we have a hashCode method generated for us?
  //hashCode method returns the same value for two Account objects
  // if all of the field values for both objects match (barring collisions due to the birthday paradox):
  @Test
  @DisplayName("Whether Hashcode method is generated?")
  public void testHashcodeMethodForAccount() {
    Account account2 = TestUtilities.getRandomAccount();
    Account account3 = new AccountManager().cloneAccount(account);
    assertEquals(account.hashCode(), account3.hashCode());
      assertNotEquals(account.hashCode(), account2.hashCode());
  }

}
