package magicGame;

import org.junit.Before;

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
}
