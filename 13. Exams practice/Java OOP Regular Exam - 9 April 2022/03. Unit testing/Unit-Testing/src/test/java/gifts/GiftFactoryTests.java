package gifts;

import org.junit.Before;

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

}
