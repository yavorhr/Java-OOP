package shopAndGoods;


import org.junit.Before;

public class ShopTest {
  private Shop shop;
  private Shop emptyShop;
  private Goods tomato;
  private Goods banana;
  private Goods apple;

  @Before
  public void setUp() {
    this.emptyShop = new Shop();
    this.shop = new Shop();

    this.tomato = new Goods("tomato", "10");
    this.banana = new Goods("banana", "20");
    this.apple = new Goods("apple", "30");

    this.shop.addGoods("Shelves1", tomato);
    this.shop.addGoods("Shelves1", banana);
    this.shop.addGoods("Shelves1", apple);
  }
}