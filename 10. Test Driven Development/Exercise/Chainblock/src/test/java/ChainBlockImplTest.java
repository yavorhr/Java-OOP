import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ChainBlockImplTest {
  private ChainblockImpl chainBlock;

  @Before
  public void setUp() {
    this.chainBlock = new ChainblockImpl();
    this.chainBlock.add(createTransaction(1, TransactionStatus.ABORTED, "01012020", "31012020", 300));
    this.chainBlock.add(createTransaction(2, TransactionStatus.FAILED, "01032020", "31032020", 500));
    this.chainBlock.add(createTransaction(3, TransactionStatus.SUCCESSFUL, "01102020", "31102020", 600));
    this.chainBlock.add(createTransaction(4, TransactionStatus.UNAUTHORIZED, "15072024", "31072024", 700));
    this.chainBlock.add(createTransaction(5, TransactionStatus.SUCCESSFUL, "13092023", "15092023", 1000));
    this.chainBlock.add(createTransaction(6, TransactionStatus.UNAUTHORIZED, "22082023", "24082023", 1500));
    this.chainBlock.add(createTransaction(7, TransactionStatus.FAILED, "26032022", "28032022", 2000));
  }

  // add, contains & getCount
  @Test
  public void testContainsWorksCorrect() {
    Assert.assertEquals(7, this.chainBlock.getCount());

    Transaction transaction = new TransactionImpl(8, TransactionStatus.FAILED, "26032022", "28032022", 1300);
    Assert.assertFalse(this.chainBlock.contains(transaction.getId()));
    Assert.assertFalse(this.chainBlock.contains(transaction));

    this.chainBlock.add(transaction);
    Assert.assertTrue(this.chainBlock.contains(transaction.getId()));
    Assert.assertTrue(this.chainBlock.contains(transaction));

    Assert.assertEquals(8, this.chainBlock.getCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTransactionWithExistingIdShouldThrowException() {
    this.chainBlock.add(new TransactionImpl(7, TransactionStatus.FAILED, "22032024", "25032024", 5000));
  }


  // Helpers

  private Transaction createTransaction(int id, TransactionStatus status, String from, String to, double amount) {
    return new TransactionImpl(id, status, from, to, amount);
  }
}