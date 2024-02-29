import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestHero {
  private static final int DUMMY_EXPERIENCE = 100;


  @Test
  public void testHeroGainsXpByKillingTargets() {

    Weapon fakeWeapon = Mockito.mock(Weapon.class);
    Target fakeTarget = Mockito.mock(Target.class);

    Hero hero = new Hero("Stamat", fakeWeapon);

    Mockito.when(fakeTarget.isDead()).thenReturn(true);
    Mockito.when(fakeTarget.giveExperience()).thenReturn(100);

    hero.attack(fakeTarget);
    Assert.assertEquals("Wrong experience", DUMMY_EXPERIENCE, hero.getExperience());
  }
}
