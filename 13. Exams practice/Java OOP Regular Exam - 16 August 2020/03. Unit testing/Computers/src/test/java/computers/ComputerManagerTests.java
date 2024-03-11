package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
  ComputerManager computerManager;
  Computer computer;
  Computer computer2;

  @Before
  public void setUp() {
    this.computerManager = new ComputerManager();
    computer = new Computer("Dell", "Inspiron", 600.00);
    computer2 = new Computer("Intel", "Rock", 935.00);
  }

  //test constructor
  @Test
  public void testConstructorShouldWorksCorrectWhenInstanceIsCreated() {
    Assert.assertEquals(0, computerManager.getComputers().size());
  }

  // test if collection is unmodifiable
  @Test(expected = UnsupportedOperationException.class)
  public void testToModifyUnmodifiableComputersShouldThrowError() {
    this.computerManager.addComputer(computer);
    this.computerManager.getComputers().remove(0);
  }

  //test addComputer
  @Test
  public void testAddComputerShouldWorkCorrect() {
    this.computerManager.addComputer(computer);
    Assert.assertEquals(1, this.computerManager.getCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddComputerNullValueShouldThrowError() {
    this.computerManager.addComputer(null);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testAddAlreadyExistingComputerShouldThrowError() {
    this.computerManager.addComputer(computer);
    this.computerManager.addComputer(new Computer("Dell", "Inspiron", 600.00));
  }

  //test removeComputer
  @Test
  public void testRemoveComputerShouldWorkCorrect() {
    this.computerManager.addComputer(computer);
    this.computerManager.removeComputer("Dell", "Inspiron");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveNoneExistingComputerShouldThrowError() {
    this.computerManager.addComputer(computer);
    this.computerManager.removeComputer("Asus", "2");
  }

  //test getComputersByManufacturerAndModel
  @Test (expected = IllegalArgumentException.class)
  public void testGetByManufacturerAndModelShouldThrowErrorWhenSuchNoneComputersExist() {
    this.computerManager.addComputer(computer);
    this.computerManager.addComputer(computer2);

    this.computerManager.getComputer("Dell", "invalid_model");
  }

  //test getComputersByManufacturer
  @Test
  public void testGetByManufacturerShouldReturnCorrectComputer() {
    this.computerManager.addComputer(computer);

    List<Computer> list = this.computerManager.getComputersByManufacturer("Dell");
    Assert.assertEquals("Dell", list.get(0).getManufacturer());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetByManufacturerShouldThrowErrorWhenNullArgumentIsGiven() {
    this.computerManager.addComputer(computer);

    this.computerManager.getComputersByManufacturer(null);
  }

  //test getGetPrice
  @Test
  public void testGetPriceShouldWorkCorrect() {
    Assert.assertEquals(600,computer.getPrice(),0);
  }
}