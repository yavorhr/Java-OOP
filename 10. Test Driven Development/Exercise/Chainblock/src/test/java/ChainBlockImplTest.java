import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

  // changeTransactionStatus(id, Status)
  @Test
  public void testChangeTransactionStatusWorksCorrect() {
    List<Transaction> transactions = createListFromIterator();
    Transaction transaction = transactions.get(0);
    Assert.assertEquals(TransactionStatus.ABORTED, transaction.getTransactionStatus());

    chainBlock.changeTransactionStatus(transaction.getId(), TransactionStatus.SUCCESSFUL);
    Assert.assertEquals(TransactionStatus.SUCCESSFUL, transaction.getTransactionStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeTransactionStatusOfNoneExistingTransactionShouldThrowError() {
    Transaction transaction = createTransaction(8, TransactionStatus.FAILED, "26032022", "28032022", 1300);
    chainBlock.changeTransactionStatus(transaction.getId(), TransactionStatus.SUCCESSFUL);
  }

  // changeTransactionStatus(id, Status)
  @Test
  public void testRemoveByIdWorksCorrect() {
    Assert.assertEquals(7, this.chainBlock.getCount());
    this.chainBlock.removeTransactionById(1);

    Assert.assertEquals(6, this.chainBlock.getCount());
    Assert.assertFalse(this.chainBlock.contains(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveByIdNoneExistingTransactionShoulThrowError() {
    this.chainBlock.removeTransactionById(0);
  }

  // getByTransactionStatus(status)
  @Test
  public void testGetByTransactionStatusShouldWorksCorrect() {
    Chainblock chainblock = new ChainblockImpl();
    chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Tom", "Dimitar", 5000));
    chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "George", "MIhail", 5000));

    Iterable<Transaction> iterable = chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    List<Transaction> transactions = createListFromIterator(iterable);

    Assert.assertEquals(1, transactions.size());
    Assert.assertEquals(TransactionStatus.FAILED, transactions.get(0).getTransactionStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void estGetByTransactionStatusNoMatchingTransactionsShouldThrowError(){
    Chainblock chainblock = new ChainblockImpl();
    chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Tom", "Dimitar", 5000));
    chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
  }

  // Helpers
  private Transaction createTransaction(int id, TransactionStatus status, String from, String to, double amount) {
    return new TransactionImpl(id, status, from, to, amount);
  }

  private List<Transaction> createListFromIterator() {
    Iterator<Transaction> iterable = this.chainBlock.iterator();
    List<Transaction> transactions = new ArrayList<>();

    while (iterable.hasNext()) {
      transactions.add(iterable.next());
    }
    return transactions;
  }

  private List<Transaction> createListFromIterator(Iterable<Transaction> iterable) {
    List<Transaction> transactions = new ArrayList<>();

    for (Transaction tr : iterable) {
      transactions.add(tr);
    }
    return transactions;
  }
}