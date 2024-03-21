package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
  private Aquarium aquarium;
  private Fish fish1;
  private Fish fish2;

  @Before
  public void setUp() {
    this.aquarium = new Aquarium("Underworld", 2);
    this.fish1 = new Fish("Sharan");
    this.fish2 = new Fish("Lavrak");

    this.aquarium.add(fish1);
    this.aquarium.add(fish2);
  }

  // test constructor and add method
  @Test
  public void testAquariumConstructorShouldWorksCorrect() {
    Aquarium testAquarium = new Aquarium("test", 10);
    Assert.assertEquals(0, testAquarium.getCount());

    Assert.assertEquals(2, this.aquarium.getCount());
    Assert.assertEquals("Underworld", this.aquarium.getName());
    Assert.assertEquals(2, this.aquarium.getCapacity());
  }

  // test setName()
  @Test(expected = NullPointerException.class)
  public void testSetNameShouldThrowExceptionWhenNullValueIsGiven() {
    new Aquarium(null, 5);
  }

  @Test(expected = NullPointerException.class)
  public void testSetNameShouldThrowExceptionWhenEmptyValueIsGiven() {
    new Aquarium("", 5);
  }

  // test setCapacity()
  @Test(expected = IllegalArgumentException.class)
  public void testSetCapacityShouldThrowExceptionWhenNullValueIsGiven() {
    new Aquarium("test_aquarium", -1);
  }

  // test add()
  @Test(expected = IllegalArgumentException.class)
  public void testAddThrowExceptionWhenNoCapacity() {
    this.aquarium.add(new Fish("test_fish"));
  }

  // test remove()
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShouldThrowExceptionWhenFishDoesNotExist() {
    this.aquarium.remove("noneExistingFish");
  }

  @Test
  public void testRemoveShouldWorksCorrect() {
    this.aquarium.remove("Sharan");
    Assert.assertEquals(1, this.aquarium.getCount());
  }

  // test sellFish()
  @Test(expected = IllegalArgumentException.class)
  public void testSellFishShouldThrowExceptionWhenFishDoesNotExist() {
    this.aquarium.sellFish("noneExistingFish");
  }

  @Test
  public void testSellFishShouldWorksCorrect() {
    Fish sharan = this.aquarium.sellFish("Sharan");
    Assert.assertFalse(sharan.isAvailable());
  }

  // test report()
  @Test
  public void testReportShouldWorksCorrect() {
    String result = this.aquarium.report();
    Assert.assertEquals("Fish available at Underworld: Sharan, Lavrak",result );
  }
}

