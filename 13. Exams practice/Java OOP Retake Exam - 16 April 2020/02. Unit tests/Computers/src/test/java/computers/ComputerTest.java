package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerTest {
  private Part ram;
  private Part hdd;
  private Part motherboard;
  private Computer computer;

  @Before
  public void setUp() {
    this.ram = new Part("RAM", 300);
    this.hdd = new Part("HDD", 200);
    this.motherboard = new Part("Motherboard", 600);
    this.computer = new Computer("Intel");

    this.computer.addPart(ram);
    this.computer.addPart(hdd);
    this.computer.addPart(motherboard);
  }

  // test constructor
  @Test
  public void testComputerConstructorShouldWorksCorrectWhenInitialized() {
    Computer computer = new Computer("test_computer");

    Assert.assertEquals(0, computer.getParts().size());
    Assert.assertEquals("test_computer", computer.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testComputerConstructorShouldThrowErrorWhenNullNameIsPassed() {
    new Computer(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testComputerConstructorShouldThrowErrorWhenEmptyStringPassed() {
    new Computer("");
  }

  // test Unmodifiable list
  @Test(expected = UnsupportedOperationException.class)
  public void testGetPartsReturnsUnmodifiableList() {
    this.computer.getParts().add(new Part("test_part", 0));
  }

  // test getTotalPrice()
  @Test
  public void testGetTotalPriceShouldReturnTotalSumOfParts() {
    double totalPrice = this.computer.getTotalPrice();
    Assert.assertEquals(1100, totalPrice, 0);
  }

  // test addPart()
  @Test
  public void testAddPartShouldWorksCorrect() {
    Assert.assertEquals(3, this.computer.getParts().size());
    Assert.assertEquals(this.computer.getParts().get(0).getName(), "RAM");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddPartShouldThrowErrorWhenNullPartIsPassed() {
    this.computer.addPart(null);
  }

  // test removePart();

  @Test
  public void testRemovePartShouldWorksCorrect() {
    boolean result = this.computer.removePart(this.ram);
    Assert.assertTrue(result);
    Assert.assertEquals(2, this.computer.getParts().size());
  }

  // getPart()
  @Test
  public void testGetPartShouldWorksCorrect() {
    Part hdd = this.computer.getPart("HDD");

    Assert.assertEquals("HDD", hdd.getName());
    Assert.assertEquals(200, hdd.getPrice(), 0);
  }

  @Test
  public void testGetPartShouldReturnNullWhenNoSuchPartExists() {
    Part part = this.computer.getPart("not_existing_part");
    Assert.assertNull(part);
  }

  // test setPrice() in Part();
  @Test
  public void testSetPriceShouldWorksCorrect() {
    this.hdd.setPrice(1000);
    Assert.assertEquals(1000, this.hdd.getPrice(), 0);
  }

  // test setName() in Part();
  @Test
  public void testSetNameShouldWorksCorrect() {
    this.hdd.setName("new_hdd_name");
    Assert.assertEquals("new_hdd_name", this.hdd.getName());
  }

}