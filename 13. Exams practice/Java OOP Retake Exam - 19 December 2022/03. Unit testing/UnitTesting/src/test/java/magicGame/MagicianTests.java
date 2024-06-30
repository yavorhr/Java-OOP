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

}
