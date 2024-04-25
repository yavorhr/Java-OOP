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
    this.diving = new Diving("blueLagoon", 3);
    this.deepWaterDiver1 = new DeepWaterDiver("Mike", 30);
    this.deepWaterDiver2 = new DeepWaterDiver("Chris", 100);
    this.diving.addDeepWaterDiver(deepWaterDiver1);
    this.diving.addDeepWaterDiver(deepWaterDiver2);
  }

  // test Diving constructor
  @Test
  public void testDivingCtorShouldWorksCorrect() {
    Assert.assertEquals("emptyDiving", emptyDiving.getName());
    Assert.assertEquals(3, emptyDiving.getCapacity());
    Assert.assertEquals(0, emptyDiving.getCount());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDivingCtorShouldThrowErrorWhenNegativeCapacity() {
    new Diving("test", -1);
  }

  @Test(expected = NullPointerException.class)
  public void testDivingCtorShouldThrowErrorWhenEmptyName() {
    new Diving("", 1);
  }

  @Test(expected = NullPointerException.class)
  public void testDivingCtorShouldThrowErrorWhenNullName() {
    new Diving(null, 1);
  }

  // test DeepWater constructor
  @Test
  public void testDiverCtorShouldWorksCorrect() {
    Assert.assertEquals("Mike", deepWaterDiver1.getName());
    Assert.assertEquals(30, deepWaterDiver1.getOxygen(), 0);
  }

  // test addDeepWaterDiver()
  @Test
  public void testAddDeepWaterDiverShouldWorksCorrect() {
    Assert.assertEquals(2, this.diving.getCount());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddDeepWaterDiverShouldThrowErrorWhenExistingDiverIsAdded() {
    this.diving.addDeepWaterDiver(new DeepWaterDiver("Mike", 100));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddDeepWaterDiverShouldThrowErrorWhenCapacityIsReached() {
    this.diving.addDeepWaterDiver(new DeepWaterDiver("George", 100));
    this.diving.addDeepWaterDiver(new DeepWaterDiver("Tony", 100));
  }

  // test removeDeepWaterDiver()
  @Test
  public void testRemoveDeepWaterDiverShouldWorksCorrect() {
    Assert.assertTrue(this.diving.removeDeepWaterDiver("Mike"));
    Assert.assertEquals(1, this.diving.getCount());
  }

  @Test
  public void testRemoveDeepWaterDiverShouldThrowErrorWhenDiverNotExist() {
    Assert.assertFalse(this.diving.removeDeepWaterDiver("Mikka"));
    Assert.assertEquals(2, this.diving.getCount());
  }
}
