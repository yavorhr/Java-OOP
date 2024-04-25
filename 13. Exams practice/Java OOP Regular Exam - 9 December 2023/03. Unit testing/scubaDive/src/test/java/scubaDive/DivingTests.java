package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {
  private Diving emptyDiving;
  private Diving diving;
  private DeepWaterDiver deepWaterDiver1;
  private DeepWaterDiver deepWaterDiver2;

  @Before
  public void setUp() {
    this.emptyDiving = new Diving("emptyDiving", 3);
    this.diving = new Diving("blueLagoon", 2);
    this.deepWaterDiver1 = new DeepWaterDiver("Mike", 30);
    this.deepWaterDiver2 = new DeepWaterDiver("Chris", 100);
    this.diving.addDeepWaterDiver(deepWaterDiver1);
    this.diving.addDeepWaterDiver(deepWaterDiver2);
  }

  // test diving constructor
  @Test
  public void testDivingCtorShouldWorksCorrect() {
    Assert.assertEquals("emptyDiving", emptyDiving.getName());
    Assert.assertEquals(3, emptyDiving.getCapacity());
    Assert.assertEquals(0, emptyDiving.getCount());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDivingCtorShouldThrowErrorWhenNegativeCapacity() {
   new Diving("test", -1);
  }

  @Test (expected = NullPointerException.class)
  public void testDivingCtorShouldThrowErrorWhenEmptyName() {
    new Diving("", 1);
  }
  @Test (expected = NullPointerException.class)
  public void testDivingCtorShouldThrowErrorWhenNullName() {
    new Diving(null, 1);
  }

}
