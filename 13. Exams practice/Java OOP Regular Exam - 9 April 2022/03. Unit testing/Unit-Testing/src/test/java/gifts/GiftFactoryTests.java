package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
  private GiftFactory emptyFactory;
  private GiftFactory giftFactory;
  private Gift gift1;
  private Gift gift2;

  @Before
  public void setUp() {
    this.emptyFactory = new GiftFactory();
    this.giftFactory = new GiftFactory();
    this.gift1 = new Gift("car", 30);
    this.gift2 = new Gift("doll", 40);

    this.giftFactory.createGift(gift1);
    this.giftFactory.createGift(gift2);
  }

  // test GiftFactory constructor
  @Test
  public void testGiftFactoryCtorShouldWorksCorrect() {
    Assert.assertEquals(0, this.emptyFactory.getPresents().size());
    Assert.assertEquals(0, this.emptyFactory.getCount());
  }

  // test Gift obj constructor
  @Test
  public void testGiftCtorShouldWorksCorrect() {
    Assert.assertEquals("car", this.gift1.getType());
    Assert.assertEquals(30, this.gift1.getMagic(), 0);
  }

  // test createGift()
  @Test
  public void testCreateGiftShouldWorksCorrect() {
    Assert.assertEquals(2, this.giftFactory.getPresents().size());
    Assert.assertEquals(2, this.giftFactory.getCount());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreateGiftShouldThrowsErrorWhenGiftAlreadyExists() {
  this.giftFactory.createGift(new Gift("car", 30));
  }
}
