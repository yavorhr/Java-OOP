package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicianTests {
  private Magician magician;
  private Magician magicianWithNoMagics;
  private Magic magic1;
  private Magic magic2;

  @Before
  public void setUp() {
    this.magicianWithNoMagics = new Magician("test", 100);

    this.magician = new Magician("Harry", 50);
    this.magic1 = new Magic("Oslo", 30);
    this.magic2 = new Magic("Predator", 50);
    this.magician.addMagic(magic1);
    this.magician.addMagic(magic2);
  }

  // test Magician constructor
  @Test
  public void testMagicianCtorWorksCorrect() {
    Assert.assertEquals("test", this.magicianWithNoMagics.getUsername());
    Assert.assertEquals(100, this.magicianWithNoMagics.getHealth());
    Assert.assertEquals(0, this.magicianWithNoMagics.getMagics().size());
  }

  @Test(expected = NullPointerException.class)
  public void testMagicianCtorThrowsNullPointerWhenEmptyNameIsGiven() {
    new Magician("", 50);
  }

  @Test(expected = NullPointerException.class)
  public void testMagicianCtorThrowsNullPointerWhenNullNameIsGiven() {
    new Magician(null, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMagicianCtorThrowsIllegalExcWhenNegativeHealthsGiven() {
    new Magician("validName", -50);
  }

  // test getMagics()
  @Test(expected = UnsupportedOperationException.class)
  public void testGetMagicsReturnUnmodifiableCollection() {
    this.magician.getMagics().remove(this.magic1);
  }

  //test takeDamage()
  @Test(expected = IllegalStateException.class)
  public void testMagicianTakeDamageShouldThrowErrorWhenMagicianIsAlreadyWithZeroPoints() {
    this.magician.takeDamage(50);
    this.magician.takeDamage(50);
  }

  @Test
  public void testMagicianTakeDamageShouldReduceMagicianHealthPoints() {
    this.magician.takeDamage(20);
    int expected = 30;
    int actual = this.magician.getHealth();

    Assert.assertEquals(expected,actual);
  }

  //test addMagic()
  @Test
  public void testAddMagicShouldAddMagicCorrect() {
    this.magician.takeDamage(20);
    int expected = 2;
    int actual = this.magician.getMagics().size();

    Assert.assertEquals(expected,actual);
  }

  @Test (expected = NullPointerException.class)
  public void testAddMagicShouldThrowErrorWhenNullIsAdded() {
    this.magician.addMagic(null);

  }

}
