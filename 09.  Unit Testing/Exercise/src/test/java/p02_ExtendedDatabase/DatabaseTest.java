package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
  private Database database;
  private static final Person[] PERSONS = {
          new Person(1, "Ivan"),
          new Person(2, "George"),
          new Person(3, "Dimitar"),
  };

  @Before
  public void initializeDatabase() throws OperationNotSupportedException {
    this.database = new Database(PERSONS);
  }

  @Test
  public void testInitializeDatabaseSuccessfully() {
    Assert.assertTrue("Count of elements is not correct", this.database.getElements().length > 0 && this.database.getElements().length <= 16);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testInitializeDatabaseWithArrayWithZeroElements() throws OperationNotSupportedException {
    Person[] arrInput = new Person[0];
    new Database(arrInput);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testInitializeDatabaseWithArrayWithMoreThan16Elements() throws OperationNotSupportedException {
    Person[] arrInput = new Person[17];
    new Database(arrInput);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testAddNullElement() throws OperationNotSupportedException {
    this.database.add(null);
  }

  @Test
  public void testAddMethodWorksCorrect() throws OperationNotSupportedException {
    this.database.add(new Person(4, "Miro"));
    Person[] persons = this.database.getElements();
    Person lastPerson = persons[persons.length - 1];

    Assert.assertEquals(4, this.database.getElements().length);
    Assert.assertEquals("Miro", lastPerson.getUsername());
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testRemoveElementFromEmptyArray() throws OperationNotSupportedException {
    Person[] persons = new Person[0];
    Database db = new Database(persons);
    db.remove();
  }

  @Test
  public void testRemoveElementWorksCorrect() throws OperationNotSupportedException {
    this.database.remove();
    Assert.assertEquals(2, this.database.getElements().length);
  }

  //Find by username

  @Test(expected = OperationNotSupportedException.class)
  public void testFindByUserNameWithNullArgument() throws OperationNotSupportedException {
    this.database.findByUsername(null);
  }

  @Test
  public void testFindByUserNameWorksCorrect() throws OperationNotSupportedException {
    Person ivan = this.database.findByUsername("Ivan");
    Assert.assertEquals("Ivan", ivan.getUsername());
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testFindByUserNameNotExistingUserInDatabase() throws OperationNotSupportedException {
    Person ivan = this.database.findByUsername("No_such_username");
  }

  //Find by id

  @Test(expected = OperationNotSupportedException.class)
  public void testFindByIdWithNotValidId() throws OperationNotSupportedException {
    Person ivan = this.database.findById(55);
  }

  @Test
  public void testFindByIdWorksCorrect() throws OperationNotSupportedException {
    Person person = this.database.findById(1);
    Assert.assertEquals(1, person.getId());
  }
}

