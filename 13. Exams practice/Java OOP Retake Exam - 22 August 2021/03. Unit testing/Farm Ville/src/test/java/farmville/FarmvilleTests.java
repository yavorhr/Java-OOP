package farmville;

import org.junit.Before;

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

  
}
