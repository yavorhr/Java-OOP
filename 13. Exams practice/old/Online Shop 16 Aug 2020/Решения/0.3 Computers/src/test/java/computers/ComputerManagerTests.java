package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        computer = new Computer("Dell", "Aspire", 400);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersShouldExceptionUnmodifiableList() {
        computerManager.getComputers().remove(0);
    }

    @Test
    public void testGetComputersShouldWorkCorrect() {
        List<Computer> computers = computerManager.getComputers();
        int expected = 0;
        Assert.assertEquals(expected, computers.size());
    }

    @Test
    public void testGetCount() {
        int expected = 0;
        int actual = computerManager.getCount();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrExceptionWhenComputerIsNull() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldExceptionWhenExistingComputerIsAdded() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void testRemoveComputerWorksCorrect() {
        computerManager.addComputer(computer);
        Computer deletedComputer = computerManager.removeComputer("Dell", "Aspire");
        Assert.assertEquals(this.computer, deletedComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldExceptionWhenNull() {
        Computer deletedComputer = computerManager.removeComputer("IBM", "OX");
    }

    @Test
    public void testGetComputersByManufacturerWorksCorrect() {
        computerManager.addComputer(computer);
        List<Computer> dell = computerManager.getComputersByManufacturer("Dell");
        int expectedSize = 1;
        Assert.assertEquals(expectedSize,dell.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldThrExceptionWhenNull() {
        computerManager.addComputer(null);
        List<Computer> dell = computerManager.getComputersByManufacturer("Dell");

    }

}