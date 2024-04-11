package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
  private Farm farm;
  private Animal chicken;
  private Animal cow;
  private Animal horse;

  @Before
  public void setUp() {
    this.farm = new Farm("bestFarm", 3);
    this.chicken = new Animal("chicken", 70);
    this.cow = new Animal("cow", 20);
    this.horse = new Animal("horse", 100);
  }

  // test constructors
  @Test
  public void testConstructorInitFarmAndAnimalObj() {
    Assert.assertEquals(3, this.farm.getCapacity());
    Assert.assertEquals(0, this.farm.getCount());
    Assert.assertEquals("bestFarm", this.farm.getName());

    Assert.assertEquals("chicken", this.chicken.getType());
    Assert.assertEquals(70, this.chicken.getEnergy(), 0);
  }

  // addAnimal
  @Test
  public void testAddAnimalShouldWorksCorrect() {
    this.farm.add(this.chicken);
    this.farm.add(this.cow);
    this.farm.add(this.horse);

    Assert.assertEquals(3, this.farm.getCount());
  }

  // addAnimal() throws error when capacity is reached
  @Test(expected = IllegalArgumentException.class)
  public void testAddAnimalShouldThrowErrorWhenNoCapacity() {
    this.farm.add(this.chicken);
    this.farm.add(this.cow);
    this.farm.add(this.horse);
    this.farm.add(new Animal("test", 10));
  }

  // addAnimal() throws error when animal type already exists
  @Test(expected = IllegalArgumentException.class)
  public void testAddAnimalShouldThrowErrorWhenAnimalTypeAlreadyExists() {
    this.farm.add(this.chicken);
    this.farm.add(new Animal("chicken", 60));
  }

  // removeAnimal()
  @Test
  public void testRemoveAnimalShouldWorksCorrect() {
    this.farm.add(this.chicken);
    Assert.assertTrue(this.farm.remove("chicken"));
    Assert.assertFalse(this.farm.remove("elephant"));
  }

  //test setters
  @Test(expected = NullPointerException.class)
  public void testSetFarmNameShouldThrowErrorWhenEmptyName() {
   new Farm("", 10);
  }

  @Test(expected = NullPointerException.class)
  public void testSetFarmNameShouldThrowErrorWhenNullName() {
    new Farm(null, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetFarmCapacityShouldThrowErrorWhenNegativeValue() {
    new Farm("testFarm", -5);
  }
}
