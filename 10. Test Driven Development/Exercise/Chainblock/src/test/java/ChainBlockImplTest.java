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
    this.chainBlock.add(createTransaction(1, TransactionStatus.ABORTED, "Hulk", "IronMan", 300));
    this.chainBlock.add(createTransaction(2, TransactionStatus.FAILED, "Hulk", "SpiderMan", 500));
    this.chainBlock.add(createTransaction(3, TransactionStatus.SUCCESSFUL, "Werewolf", "Jene", 600));
    this.chainBlock.add(createTransaction(4, TransactionStatus.UNAUTHORIZED, "Batman", "Robin", 700));
    this.chainBlock.add(createTransaction(5, TransactionStatus.SUCCESSFUL, "Batman", "CatWoman", 1000));
    this.chainBlock.add(createTransaction(6, TransactionStatus.UNAUTHORIZED, "CaptainAmerica", "Hulk", 1500));
    this.chainBlock.add(createTransaction(7, TransactionStatus.FAILED, "Magnitto", "Prof.X", 2000));
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
    List<Transaction> transactions = createTransactionListFromIterable();
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
    Iterable<Transaction> iterable = this.chainBlock.getByTransactionStatus(TransactionStatus.FAILED);
    List<Transaction> transactions = createTransactionListFromIterable(iterable);

    Assert.assertEquals(2, transactions.size());
    Assert.assertEquals(TransactionStatus.FAILED, transactions.get(0).getTransactionStatus());
    Assert.assertEquals(TransactionStatus.FAILED, transactions.get(1).getTransactionStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void estGetByTransactionStatusNoMatchingTransactionsShouldThrowError() {
    Chainblock chainblock = new ChainblockImpl();
    chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Tom", "Dimitar", 5000));
    chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
  }

  // getAllSendersWithTransactionStatus(status)
  @Test
  public void testGetAllSendersWithTransactionStatusWorksCorrect() {
    Iterable<String> iterable = this.chainBlock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    List<String> senders = createStringListFromIterable(iterable);

    Assert.assertEquals(2, senders.size());
    Assert.assertEquals("Hulk", senders.get(0));
    Assert.assertEquals("Magnitto", senders.get(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetAllSendersWithTransactionStatusEmptyReturnShouldThrowError() {
    Chainblock chainblock = new ChainblockImpl();
    chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Tom", "Dimitar", 5000));
    chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
  }

  // getAllReceiversWithTransactionStatus(status)
  @Test
  public void testGetAllReceiversWithTransactionStatusWorksCorrect() {
    Iterable<String> iterable = this.chainBlock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    List<String> receivers = createStringListFromIterable(iterable);

    Assert.assertEquals(2, receivers.size());
    Assert.assertEquals("SpiderMan", receivers.get(0));
    Assert.assertEquals("Prof.X", receivers.get(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetAllReceiversWithTransactionStatusEmptyReturnShouldThrowError() {
    Chainblock chainblock = new ChainblockImpl();
    chainblock.add(new TransactionImpl(1, TransactionStatus.FAILED, "Tom", "Dimitar", 5000));
    chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
  }

  // Helpers
  private Transaction createTransaction(int id, TransactionStatus status, String from, String to, double amount) {
    return new TransactionImpl(id, status, from, to, amount);
  }

  private List<Transaction> createTransactionListFromIterable() {
    Iterator<Transaction> iterable = this.chainBlock.iterator();
    List<Transaction> transactions = new ArrayList<>();

    while (iterable.hasNext()) {
      transactions.add(iterable.next());
    }
    return transactions;
  }

  private List<Transaction> createTransactionListFromIterable(Iterable<Transaction> iterable) {
    List<Transaction> transactions = new ArrayList<>();

    for (Transaction tr : iterable) {
      transactions.add(tr);
    }
    return transactions;
  }

  private List<String> createStringListFromIterable(Iterable<String> iterable) {
    List<String> transactions = new ArrayList<>();

    for (String string : iterable) {
      transactions.add(string);
    }
    return transactions;
  }
}