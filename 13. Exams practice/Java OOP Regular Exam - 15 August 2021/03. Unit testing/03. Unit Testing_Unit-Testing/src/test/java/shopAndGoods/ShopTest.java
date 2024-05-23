package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {
  private Shop shop;
  private Shop emptyShop;
  private Goods tomato;
  private Goods banana;
  private Goods apple;

  @Before
  public void setUp() throws OperationNotSupportedException {
    this.emptyShop = new Shop();
    this.shop = new Shop();

    this.tomato = new Goods("tomato", "10");
    this.banana = new Goods("banana", "20");
    this.apple = new Goods("apple", "30");

    this.shop.addGoods("Shelves1", tomato);
    this.shop.addGoods("Shelves2", banana);
    this.shop.addGoods("Shelves3", apple);
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
    Assert.assertEquals("apple",apple.getName());
    Assert.assertEquals("30",apple.getGoodsCode());
  }






}