package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

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

  //test BankVault constructor
  @Test
  public void testBankVaultConstructorInitObj() {
    int actualSafeSize = this.bankVault.getVaultCells().size();
    int expected = 12;

    Assert.assertEquals(actualSafeSize, expected);
    Assert.assertNull(this.bankVault.getVaultCells().get("A1"));
  }

  //test getVaultCells()
  @Test(expected = UnsupportedOperationException.class)
  public void testBankVaultGetVaultCells() {
    this.bankVault.getVaultCells().put("C5", null);
  }

  //test addItem()
  @Test(expected = IllegalArgumentException.class)
  public void testAddItemShouldThrowErrorWhenAddToNoneExistingCell() throws OperationNotSupportedException {
    this.bankVault.addItem("ZYD", item1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddItemShouldThrowErrorWhenCellIsNotEmpty() throws OperationNotSupportedException {
    this.bankVault.addItem("A", item1);
    this.bankVault.addItem("A", item2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddItemShouldThrowErrorWhenItemIsAddedToOtherCell() throws OperationNotSupportedException {
    this.bankVault.addItem("A", item1);
    this.bankVault.addItem("B", item1);
  }
}