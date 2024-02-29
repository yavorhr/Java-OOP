package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

  private ListIterator listIterator;

  @Before
  public void initializeListIterator() throws OperationNotSupportedException {
    this.listIterator = new ListIterator("a", "b", "c");
  }

  //Constructor
  @Test(expected = OperationNotSupportedException.class)
  public void testInitializeWithNull() throws OperationNotSupportedException {
    new ListIterator(null);
  }

  //test move and hasNext
  @Test
  public void testMoveWorksCorrect() {
    Assert.assertTrue(this.listIterator.move());
  }

  @Test
  public void testMoveWhenLastIndexIsReached() {
    while (listIterator.hasNext()) {
      listIterator.move();
    }
    Assert.assertFalse(listIterator.move());
  }

  // print
  @Test
  public void testPrintWorksCorrect() {
    String print = listIterator.print();
    Assert.assertEquals("a", print);
  }

  @Test(expected = IllegalStateException.class)
  public void testPrintEmptyClass() throws OperationNotSupportedException {
    ListIterator listIterator = new ListIterator();
    listIterator.print();
  }

}