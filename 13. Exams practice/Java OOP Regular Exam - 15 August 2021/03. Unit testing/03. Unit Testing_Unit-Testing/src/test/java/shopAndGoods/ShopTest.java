package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {
  private Shop shop;
  private Shop emptyShop;
  private Goods apple;

  @Before
  public void setUp() throws OperationNotSupportedException {
    this.emptyShop = new Shop();
    this.shop = new Shop();

    this.apple = new Goods("apple", "30");
  }

  //test constructors
  @Test
  public void testShopConstructorShouldReturn12Shelves() {
    int actual = emptyShop.getShelves().values().size();
    int expected = 12;
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGoodsConstructor() {
    Assert.assertEquals("apple", apple.getName());
    Assert.assertEquals("30", apple.getGoodsCode());
  }

  // test addGoods()
  @Test
  public void testAddGoodsShouldWorksCorrect() throws OperationNotSupportedException {
    String expected = "Goods: 30 is placed successfully!";
    String actual = this.shop.addGoods("Shelves3", apple);
    Assert.assertEquals(expected, actual);

  }


}