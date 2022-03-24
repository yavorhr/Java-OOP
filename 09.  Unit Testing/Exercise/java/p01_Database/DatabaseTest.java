package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 29, 45};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
         database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorToCreateValidObject() throws OperationNotSupportedException {
        Integer[] databaseNumbers = database.getElements();

        Assert.assertEquals("Count of elements is incorrect", NUMBERS.length, database.getElements().length);

        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(17);
        //5, 8, 29, 45, 17
        Assert.assertEquals(5, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17), database.getElements()[4]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void RemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] elementsInDataBase = database.getElements();

        Assert.assertEquals(NUMBERS.length - 1, elementsInDataBase.length);
        for (int i = 0; i < elementsInDataBase.length; i++) {
            Assert.assertEquals(elementsInDataBase[i], NUMBERS[i]);
        }
    }
}
