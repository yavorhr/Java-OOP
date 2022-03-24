package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "First"), new Person(2, "Second"), new Person(3, "Third")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorToCreateValidObject() throws OperationNotSupportedException {
        Person[] databaseNumbers = database.getElements();

        Assert.assertEquals("Count of elements is incorrect", PEOPLE.length, database.getElements().length);

        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(PEOPLE[i], databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new p01_Database.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        //p1,p2,p3
        database.add(new Person(4, "Fourth"));
        //p1,p2,p3,p4
        Assert.assertEquals(4, database.getElements().length);
        Assert.assertEquals(4, database.getElements()[3].getId());
        Assert.assertEquals("Fourth", database.getElements()[3].getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void RemoveLastElement() throws OperationNotSupportedException {
        //p1, p2, p3
        database.remove();
        //p1, p2
        Person[] elementsInDataBase = database.getElements();
        //проверка дали са сме махнали последния елемент
        Assert.assertEquals(PEOPLE.length - 1, elementsInDataBase.length);
        Assert.assertEquals(2, elementsInDataBase[elementsInDataBase.length - 1].getId());
        Assert.assertEquals("Second", elementsInDataBase[elementsInDataBase.length - 1].getUsername());

        for (int i = 0; i < elementsInDataBase.length; i++) {
            Assert.assertEquals(elementsInDataBase[i], PEOPLE[i]);
        }
    }

    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        //userName = "First", id = 1
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }

    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        //userName = "First", id = 1
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

        Person resultPerson2 = database.findById(2);
        //userName = "Second", id = 2
        Assert.assertEquals(2, resultPerson2.getId());
        Assert.assertEquals("Second", resultPerson2.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }
}
