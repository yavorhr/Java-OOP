package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;
    private Part part;

    @Before
    public void SetUP() {
        this.computer = new Computer("Dell");
        this.part = new Part("Motherboard", 180);
    }

    @Test
    public void testParts(){
        List<Part> parts = computer.getParts();
        int expected = 0;
        Assert.assertEquals(expected,parts.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldThrExceptionNullName() {
        Computer computer = new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldThrExceptionEmptyName() {
        Computer computer = new Computer("");
    }


    @Test
    public void testGetName() {
        String actualName = computer.getName();
        String expectedName = "Dell";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsShouldThrowExceptionUnmodifiable() {
        computer.getParts().remove(0);
    }

    @Test
    public void testGetTotalPrice() {
        computer.addPart(part);
        double totalPrice = computer.getTotalPrice();
        Assert.assertEquals(180, totalPrice, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartShouldThrExceptionWhenNull() {
        computer.addPart(null);
    }

    @Test
    public void testAddPartWorksCorrect() {
        computer.addPart(part);
        Part part = computer.getParts().get(0);
        Assert.assertEquals(this.part, part);
    }

    @Test
    public void testRemovePart() {
        computer.addPart(part);
        boolean removedPart = computer.removePart(part);
        Assert.assertTrue(removedPart);
    }

    @Test
    public void testGetPartWorksCorrect() {
        computer.addPart(part);
        Part motherboard = computer.getPart("Motherboard");
        Assert.assertEquals(part,motherboard);
    }

    @Test
    public void testGetPartWhenNull() {
        Part motherboard = computer.getPart("Motherboard");
       Assert.assertNull(motherboard);
    }

    @Test
    public void testGetParts() {
      computer.addPart(part);
        List<Part> parts = computer.getParts();
        int expected = 1;
        Assert.assertEquals(expected,parts.size());
    }



}