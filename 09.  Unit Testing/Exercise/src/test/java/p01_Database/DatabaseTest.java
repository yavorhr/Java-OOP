package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
  private Database database;
  private static final Integer[] NUMBERS = {1, 2, 3, 4};

  @Before
  public void initializeDatabase() throws OperationNotSupportedException {
    this.database = new Database(NUMBERS);
  }
  // Test Constructor
  // 1. test length
  // 2. test elements
  // a) < 16 -> OperationNotSupportedException
  // b) > 16 -> OperationNotSupportedException
  // c) == 16
  // 3. test lastIndex

  @Test
  public void testInitializeDatabaseSuccessfully() throws OperationNotSupportedException {
    Assert.assertTrue("Count of elements is not correct", this.database.getElements().length > 0 && this.database.getElements().length <= 16);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testInitializeDatabaseWithArrayWithZeroElements() throws OperationNotSupportedException {
    Integer[] arrInput = new Integer[0];
    new Database(arrInput);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testInitializeDatabaseWithArrayWithMoreThan16Elements() throws OperationNotSupportedException {
    Integer[] arrInput = new Integer[17];
    new Database(arrInput);
  }

  //II. Test add method
  //1. add null element
  //2. add method works correct

  @Test(expected = OperationNotSupportedException.class)
  public void testAddNullElement() throws OperationNotSupportedException {
    this.database.add(null);
  }

  @Test
  public void testAddMethodWorksCorrect() throws OperationNotSupportedException {
    this.database.add(13);
    Integer[] numbers = this.database.getElements();
    int lastElement = numbers[numbers.length - 1];

    Assert.assertEquals(5, this.database.getElements().length);
    Assert.assertEquals(13, lastElement);
  }

  //III. Test remove method

  @Test(expected = OperationNotSupportedException.class)
  public void testRemoveElementFromEmptyArray() throws OperationNotSupportedException {
    Integer[] arrInput = new Integer[0];
    Database db = new Database(arrInput);
    db.remove();
  }

  @Test
  public void testRemoveElementWorksCorrect() throws OperationNotSupportedException {
    this.database.remove();
    Assert.assertEquals(3, this.database.getElements().length);
  }
}

