import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {

  @Test
  public void testBankAccountCreationStartsWithZero() {

    BankAccount bankAccount = new BankAccount();
    double balance = bankAccount.getBalance();
    Assert.assertEquals(0.0, balance,0);
  }

  @Test
  public void testDepositShouldIncreaseAmountCorrectly() {
    //Arrange
    BankAccount bankAccount = new BankAccount();
    //Act
    bankAccount.deposit(50);
    double balance = bankAccount.getBalance();
    //Assert
    Assert.assertEquals(50, balance,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositMethodShouldThrowIllegalArgumentExceptionWhenNegativeDepositIsGiven(){
    BankAccount bankAccount = new BankAccount();
    bankAccount.deposit(-300);

  }

}
