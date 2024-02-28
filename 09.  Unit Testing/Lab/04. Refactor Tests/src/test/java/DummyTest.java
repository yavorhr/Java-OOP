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
  private Hero hero;

  @Before
  public void initializeTestObjects(){
    this.hero = new Hero("Ivan");
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

  @Test
  public void testDeadDummyGivesExperience() {
    Dummy dummy = new Dummy(10, DUMMY_EXPERIENCE);
    this.hero.attack(dummy);

    int experience = this.hero.getExperience();
    Assert.assertEquals(100, experience);
  }

  @Test
  public void testAliveDummyDontGiveExperience() {
    this.hero.attack(this.dummy);

    int experience = this.hero.getExperience();
    Assert.assertEquals(0, experience);
  }
}