import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
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
  public void testIfWeaponLosesDurabilityWhenAttack() {
    this.axe.attack(this.dummy);
    Assert.assertEquals(9, axe.getDurabilityPoints());
  }

  @Test(expected = IllegalStateException.class)
  public void testIfWeaponLosesAllItsDurabilityWhenAttack() {
    for (int i = 0; i <= 10; i++) {
      this.axe.attack(this.dummy);
    }
  }
}