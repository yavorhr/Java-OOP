import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
  private static final int AXE_ATTACK = 10;
  private static final int AXE_DURABILITY = 10;
  private static final int DUMMY_HEALTH = 100;
  private static final int DUMMY_EXPERIENCE = 100;

  private Axe axe;
  private Dummy dummy;

  @Before
  public void initializeTestObjects(){
    this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
  }

  @Test
  public void testDummyLosesHealthWhenAttacked() {
    this.dummy.takeAttack(50);
    Assert.assertEquals(50, this.dummy.getHealth());
  }

  @Test(expected = IllegalStateException.class)
  public void testAttackDeadDummy() {
    this.dummy.takeAttack(100);
    this.dummy.takeAttack(10);
  }

}