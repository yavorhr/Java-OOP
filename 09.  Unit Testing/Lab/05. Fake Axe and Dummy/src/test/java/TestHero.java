import org.junit.Assert;
import org.junit.Test;

public class TestHero {
  private static final int DUMMY_EXPERIENCE = 100;


  @Test
  public void testHeroGainsXpByKillingTargets() {
    Target fakeTarget = new Target() {
      @Override
      public boolean isDead() {
        return true;
      }

      @Override
      public int giveExperience() {
        return DUMMY_EXPERIENCE;
      }

      @Override
      public void takeAttack(int attackPoints) {

      }
    };

    Weapon fakeWeapon = new Weapon() {
      @Override
      public void attack(Target target) {

      }
    };

    Hero hero = new Hero("Stamat", fakeWeapon);
    hero.attack(fakeTarget);
    Assert.assertEquals("Wrong experience", DUMMY_EXPERIENCE, hero.getExperience());
  }
}
