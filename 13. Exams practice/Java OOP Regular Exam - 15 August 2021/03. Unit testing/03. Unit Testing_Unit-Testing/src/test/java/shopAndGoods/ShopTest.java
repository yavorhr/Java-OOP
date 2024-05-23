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

  @Test(expected = IllegalArgumentException.class)
  public void testAddGoodsThrowErrorWhenShelfDoesNotExist() throws OperationNotSupportedException {
    this.shop.addGoods("Shelves333", apple);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddGoodsThrowErrorWhenProductAlreadyExist() throws OperationNotSupportedException {
    this.shop.addGoods("Shelves3", apple);
    this.shop.addGoods("Shelves3", apple);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddGoodsThrowErrorWhenShelfIsTaken() throws OperationNotSupportedException {
    this.shop.addGoods("Shelves3", apple);
    this.shop.addGoods("Shelves3", new Goods("banana", "321"));
  }

  // test removeGoods()

  @Test
  public void testRemoveGoodsShouldWorksCorrect() throws OperationNotSupportedException {
    this.shop.addGoods("Shelves3", apple);
    String actual = this.shop.removeGoods("Shelves3", apple);
    String expected = "Goods: 30 is removed successfully!";
    
    Assert.assertEquals(expected, actual);
  }


}