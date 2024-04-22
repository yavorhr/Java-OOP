package bankSafe;


import org.junit.Before;

public class BankVaultTest {
  private BankVault bankVault;
  private Item item1;
  private Item item2;


  @Before
  public void setUp() {
    this.bankVault = new BankVault();
    item1 = new Item("George", "123");
    item2 = new Item("Mike", "1234");
  }


}