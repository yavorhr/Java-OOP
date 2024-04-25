package scubaDive;


import org.junit.Before;

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
}
