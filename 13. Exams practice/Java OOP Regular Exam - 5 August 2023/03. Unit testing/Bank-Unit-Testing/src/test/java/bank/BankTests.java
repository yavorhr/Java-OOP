package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
  private Client client1;
  private Client client2;
  private Bank bank;

  @Before
  public void setUp() {
    this.client1 = new Client("Dimitar");
    this.client2 = new Client("George");
    this.bank = new Bank("DSK", 2);

    this.bank.addClient(client1);
    this.bank.addClient(client2);
  }

  // test Bank constructor
  @Test
  public void testBankIsInitializedCorrectly() {
    Assert.assertEquals(2, this.bank.getCount());
    Assert.assertEquals("DSK", this.bank.getName());
    Assert.assertEquals(2, this.bank.getCapacity());

    Bank testBank = new Bank("test", 10);
    Assert.assertEquals(0, testBank.getCount());
  }

  @Test(expected = NullPointerException.class)
  public void testBankIsInitializedWithEmptyName() {
    new Bank("", 10);
  }

  @Test(expected = NullPointerException.class)
  public void testBankIsInitializedWithNullName() {
    new Bank(null, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBankIsInitializedWithInvalidCapacity() {
    new Bank("testBank", -1);
  }

  // test addClient()
  @Test(expected = IllegalArgumentException.class)
  public void testAddClientShouldThrowErrorWhenNoCapacityIsAvailable() {
    this.bank.addClient(new Client("Stamat"));
  }

  // test removeClient()
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveClientShouldThrowErrorWhenClientDoesntExist() {
    this.bank.removeClient("invalid_client");
  }

  @Test
  public void testRemoveClientShouldWorksCorrect() {
    this.bank.removeClient("Dimitar");
  }

  //test loanWithdrawal
  @Test
  public void testLoanWithdrawalWorksCorrect() {
    Client client = this.bank.loanWithdrawal("Dimitar");
    Assert.assertFalse(client.isApprovedForLoan());
    Assert.assertEquals("Dimitar", client.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLoanWithdrawalShouldThrowErrorWhenClientDoesntExist() {
    Client client = this.bank.loanWithdrawal("invalid_client");
  }

  //test statisticsa
  @Test
  public void testStatisticsShouldWorksCorrect() {
    String statistics = this.bank.statistics();
    Assert.assertEquals("The client Dimitar, George is at the DSK bank!", statistics);
  }
}
