package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
  private House house;
  private House testHouse;
  private Cat cat1;
  private Cat cat2;
  private Cat cat3;

  @Before
  public void setUp() {
    house = new House("underworld", 3);
    testHouse = new House("tesHouse", 1);
    house.addCat(cat1 = new Cat("Lady"));
    house.addCat(cat2 = new Cat("Spot"));
    house.addCat(cat3 = new Cat("Mint"));
  }

  //test house constructor
  @Test
  public void testHouseConstructorShouldInitHouse() {
    Assert.assertEquals(3, this.house.getCapacity());
    Assert.assertEquals(3, this.house.getCount());
    Assert.assertEquals("underworld", this.house.getName());
  }

  //test house name with invalid name
  @Test(expected = NullPointerException.class)
  public void testSetHouseNameWithEmptyNameShouldThrowError() {
    new House("", 5);
  }

  @Test(expected = NullPointerException.class)
  public void testSetHouseNameWithNullNameShouldThrowError() {
    new House(null, 5);
  }

  //test house name with invalid capacity
  @Test(expected = IllegalArgumentException.class)
  public void testSetHouseCapacityWithNegativeValueThrowError() {
    new House("testHouse", -1);
  }

  //test addCat()
  @Test(expected = IllegalArgumentException.class)
  public void testAddCatWithNullShouldThrowError() {
    this.house.addCat(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddCatWhenFullCapacityShouldThrowError() {
    this.house.addCat(new Cat("cat4"));
  }

  //test addCat()
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveCatWhenNoneExistingCatShouldThrowError() {
    this.house.removeCat("cat4");
  }

  @Test
  public void testRemoveCatShouldWorksCorrect() {
    this.house.removeCat("Lady");
    Assert.assertEquals(2, this.house.getCount());
  }

  //test catForSale()
  @Test(expected = IllegalArgumentException.class)
  public void testCatForSaleNoneExistingCatShouldThrowError() {
    this.house.catForSale("cat4");
  }

  @Test
  public void testCatForSaleShouldWorksCorrect() {
    Cat cat1 = this.house.catForSale("Lady");
    Assert.assertFalse(cat1.isHungry());
  }

  // test statistics()
  @Test
  public void testStatisticsShouldWorksCorrect() {
    String result = this.house.statistics();
    Assert.assertEquals("The cat Lady, Spot, Mint is in the house underworld!", result);
  }

}
