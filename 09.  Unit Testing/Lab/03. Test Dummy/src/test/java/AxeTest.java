import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

  @Test
  public void testIfWeaponLosesDurabilityWhenAttack() {
    Axe axe = new Axe(10, 10);
    Dummy dummy = new Dummy(100, 100);

    axe.attack(dummy);
    Assert.assertEquals(9, axe.getDurabilityPoints());
  }


  @Test(expected = IllegalStateException.class)
  public void testIfWeaponLosesAllItsDurabilityWhenAttack() {
    Axe axe = new Axe(10, 10);
    Dummy dummy = new Dummy(100, 100);

    for (int i = 0; i <= 10; i++) {
      axe.attack(dummy);
    }

  }
}