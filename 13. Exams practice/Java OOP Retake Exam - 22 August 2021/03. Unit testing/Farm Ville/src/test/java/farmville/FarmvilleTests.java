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
}
