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
    this.chainBlock.add(createTransaction(5, TransactionStatus.SUCCESSFUL, "Batman", "Hulk", 1000));
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
  public void testRemoveByIdNoneExistingTransactionShouldThrowError() {
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

  // getAllOrderedByAmountDescendingThenById()
  @Test
  public void testGetAllOrderedByAmountDescendingThenById() {
    Iterable<Transaction> iterable = this.chainBlock.getAllOrderedByAmountDescendingThenById();
    List<Transaction> transactions = createTransactionListFromIterable(iterable);
    int lastIndex = transactions.size() - 1;

    Assert.assertEquals("Magnitto", transactions.get(0).getSender());
    Assert.assertEquals("Hulk", transactions.get(lastIndex).getSender());
    Assert.assertEquals(2000, transactions.get(0).getAmount(), 0);
    Assert.assertEquals(300, transactions.get(lastIndex).getAmount(), 0);
  }

  // getBySenderOrderedByAmountDescending()
  @Test
  public void testGetBySenderOrderedByAmountDescendingShouldWorkCorrect() {
    Iterable<Transaction> iterable = this.chainBlock.getBySenderOrderedByAmountDescending("Batman");
    List<Transaction> transactionsBySender = createTransactionListFromIterable(iterable);

    Assert.assertEquals(2, transactionsBySender.size());

    Assert.assertEquals("Batman", transactionsBySender.get(0).getSender());
    Assert.assertEquals(1000, transactionsBySender.get(0).getAmount(), 0);
    Assert.assertEquals(700, transactionsBySender.get(1).getAmount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetBySenderOrderedByAmountDescendingShouldThrowErrorWhenEmptyCollectionIsReturned() {
    this.chainBlock.getBySenderOrderedByAmountDescending("invalid_sender");
  }

  // getByReceiverOrderedByAmountThenById(receiver)
  @Test
  public void testGetByReceiverOrderedByAmountThenByIdShouldWorkCorrect() {
    Iterable<Transaction> iterable = this.chainBlock.getByReceiverOrderedByAmountThenById("Hulk");
    List<Transaction> transactionsByReceiver = createTransactionListFromIterable(iterable);

    Assert.assertEquals(2, transactionsByReceiver.size());

    Assert.assertEquals("Hulk", transactionsByReceiver.get(0).getReceiver());
    Assert.assertEquals(1500, transactionsByReceiver.get(0).getAmount(), 0);
    Assert.assertEquals(1000, transactionsByReceiver.get(1).getAmount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetByReceiverOrderedByAmountThenByIdShouldThrowErrorWhenEmptyCollectionIsReturned() {
    this.chainBlock.getByReceiverOrderedByAmountThenById("invalid_sender");
  }

  // getByTransactionStatusAndMaximumAmount(status, amount)

  @Test
  public void testGetByTransactionStatusAndMaximumAmount() {
    Iterable<Transaction> iterable = this.chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 700);
    List<Transaction> transactions = createTransactionListFromIterable(iterable);

    Assert.assertEquals(1, transactions.size());
    Assert.assertEquals(TransactionStatus.FAILED, transactions.get(0).getTransactionStatus());
    Assert.assertEquals(500, transactions.get(0).getAmount(),0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetByTransactionStatusAndMaximumAmountShouldThrowErrorWhenEmptyCollectionIsReturned() {
    this.chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 100);
  }

  // getBySenderAndMinimumAmountDescending(status, amount)

  @Test
  public void testGetBySenderAndMinimumAmountDescendingShouldWorksCorrect() {
    Iterable<Transaction> iterable = this.chainBlock.getBySenderAndMinimumAmountDescending("Hulk", 300);
    List<Transaction> transactions = createTransactionListFromIterable(iterable);

    Assert.assertEquals(2, transactions.size());

    Assert.assertEquals("Hulk", transactions.get(0).getSender());
    Assert.assertEquals(500, transactions.get(0).getAmount(), 0);
    Assert.assertEquals(300, transactions.get(1).getAmount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetBySenderAndMinimumAmountDescendingShouldThrowErrorWhenEmptyCollectionIsReturned() {
    this.chainBlock.getBySenderAndMinimumAmountDescending("Hulk", 5000);
  }

  // getByReceiverAndAmountRange(receiver, lo, hi) (status, amount)

  @Test
  public void testGetByReceiverAndAmountRangeShouldWorkCorrect() {
    Iterable<Transaction> iterable = this.chainBlock.getByReceiverAndAmountRange("Hulk", 1000, 1501);
    List<Transaction> transactions = createTransactionListFromIterable(iterable);

    Assert.assertEquals(2, transactions.size());

    Assert.assertEquals("Hulk", transactions.get(0).getReceiver());
    Assert.assertEquals(1500, transactions.get(0).getAmount(), 0);
    Assert.assertEquals(1000, transactions.get(1).getAmount(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetByReceiverAndAmountRangeShouldThrowErrorWhenEmptyCollectionIsReturned() {
    this.chainBlock.getByReceiverAndAmountRange("Hulk", 1501, 1502);
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