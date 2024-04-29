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

  @Test(expected = IllegalArgumentException.class)
  public void testCreateGiftShouldThrowsErrorWhenGiftAlreadyExists() {
    this.giftFactory.createGift(new Gift("car", 30));
  }

  // test removeGift()
  @Test(expected = NullPointerException.class)
  public void testRemoveGiftShouldThrowsErrorWhenGiftIsEmpty() {
    this.giftFactory.removeGift("");
  }

  @Test(expected = NullPointerException.class)
  public void testRemoveGiftShouldThrowsErrorWhenGiftIsNull() {
    this.giftFactory.removeGift(null);
  }

  @Test
  public void testRemoveGiftShouldReturnFalseWhenGiftNotExist() {
    Assert.assertFalse(this.emptyFactory.removeGift("test"));
  }

  @Test
  public void testRemoveGiftShouldReturnTrueWhenGiftIsRemoved() {
    Assert.assertTrue(this.giftFactory.removeGift("car"));
  }

  //test getPresentWithLeastMagic()
  @Test
  public void testGetPresentWithLeastMagic() {
    Gift presentWithLeastMagic = this.giftFactory.getPresentWithLeastMagic();

    Assert.assertEquals("car", presentWithLeastMagic.getType());
    Assert.assertEquals(30, presentWithLeastMagic.getMagic(), 0);
  }

  //test getPresent()
  @Test
  public void testGetPresent() {
    Gift present = this.giftFactory.getPresent("doll");

    Assert.assertEquals("doll", present.getType());
    Assert.assertEquals(40, present.getMagic(), 0);
  }

  //test getPresents() Unmodifiable coll
  @Test(expected = UnsupportedOperationException.class)
  public void testGetPresentReturnsUnmodifiableCollection() {
  this.giftFactory.getPresents().add(new Gift("test", 123));
  }
}

