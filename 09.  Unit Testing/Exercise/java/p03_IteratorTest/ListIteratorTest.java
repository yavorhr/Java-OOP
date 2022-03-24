package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"X", "Y", "Z"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextReturnCorrectBoolean() {
        //"X", "Y", "Z"
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        ;
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        //"X", "Y", "Z"
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCorrectly(){
        //"X", "Y", "Z"
        int index = 0;
        while (listIterator.hasNext()){
            Assert.assertEquals(DATA[index],listIterator.print());
            index++;
            listIterator.move();
        }
    }
}
