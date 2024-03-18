package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
  private Gun gun1;
  private Gun gun2;
  private Player player;
  private Player player2;

  @Before
  public void setUp() {
    gun1 = new Gun("AK47", 45);
    gun2 = new Gun("Magnum", 12);

    player = new Player("Venom", 100);
    player.addGun(gun1);
    player.addGun(gun2);

    player2 = new Player("Imortal", 100);
  }

  //test constructor
  @Test
  public void testPlayerConstructor() {
    Assert.assertEquals("Venom", player.getUsername());
    Assert.assertEquals(100, player.getHealth());
    Assert.assertEquals(2, player.getGuns().size());
    Assert.assertEquals(0, player2.getGuns().size());
  }

  //test setUsername()
  @Test(expected = NullPointerException.class)
  public void testInitPlayerWithEmptyUsernameShouldThrowError() {
    new Player("", 100);
  }

  @Test(expected = NullPointerException.class)
  public void testInitPlayerWithNullUsernameShouldThrowError() {
    new Player(null, 100);
  }

  //test setHealth()
  @Test(expected = IllegalArgumentException.class)
  public void testInitPlayerWithNegativeHealthShouldThrowError() {
    new Player("test_username", -1);
  }

  //test takeDamage()
  @Test
  public void testTakeDamageWhenDamageIsGreaterThanHealthPoints() {
    player.takeDamage(120);
    Assert.assertEquals(0, player.getHealth());
  }

  @Test(expected = IllegalStateException.class)
  public void testTakeDamageWhenHealthPointsAreAlreadyZero() {
    player.takeDamage(100);
    player.takeDamage(100);
  }

  //test takeDamage()
  @Test
  public void testTakeDamageWhenDamageIsLessThanHealthPoints() {
    player.takeDamage(50);
    Assert.assertEquals(50, player.getHealth());
  }

  //test getGuns() Unmodifiable
  @Test(expected = UnsupportedOperationException.class)
  public void testInitGetGunsReturnsUnmodifiableList() {
    player.getGuns().add(gun1);
  }

  //test addGun()
  @Test(expected = NullPointerException.class)
  public void testAddGunNullGunShouldThrowError() {
    player.addGun(null);
  }

  //test removeGun()
  @Test
  public void testRemoveGunShouldWorkCorrect() {
    boolean result = player.removeGun(gun1);
    Assert.assertTrue(result);

    boolean result2 = player2.removeGun(gun1);
    Assert.assertFalse(result2);
  }

  // test GetGun()
  @Test
  public void testGetGunShouldWorkCorrect() {
    Gun ak47 = player.getGun("AK47");
    Assert.assertEquals(gun1, ak47);
  }

  // test GetGun()
  @Test
  public void testGetGunsBulletsShouldWorkCorrect() {
    int bulletsCount = player.getGun("AK47").getBullets();
    Assert.assertEquals(45, bulletsCount);
  }
}

