import org.junit.Assert;
import org.junit.Test;

public class DummyTest {

  @Test
  public void testDummyLosesHealthWhenAttacked() {
    Dummy dummy = new Dummy(100, 100);
    dummy.takeAttack(50);

    Assert.assertEquals(50, dummy.getHealth());
  }

  @Test(expected = IllegalStateException.class)
  public void testAttackDeadDummy() {
    Dummy dummy = new Dummy(100, 100);
    dummy.takeAttack(100);
    dummy.takeAttack(10);
  }

  @Test
  public void testDeadDummyGivesExperience() {
    Hero hero = new Hero("Ivan");
    Dummy dummy = new Dummy(10, 100);
    hero.attack(dummy);

    int experience = hero.getExperience();
    Assert.assertEquals(100, experience);
  }

  @Test
  public void testAliveDummyDontGiveExperience() {
    Hero hero = new Hero("Ivan");
    Dummy dummy = new Dummy(20, 100);
    hero.attack(dummy);

    int experience = hero.getExperience();
    Assert.assertEquals(0, experience);
  }
}