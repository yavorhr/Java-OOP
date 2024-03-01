import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ProductStockTest {
  private ProductStock stock;

  @Before
  public void setUp() {
    this.stock = new Instock();
  }

  @Test
  public void testCountShouldReturnCorrectSize() {
    Assert.assertEquals(0, stock.getCount());
    stock.add(new Product());
    Assert.assertEquals(1, stock.getCount());
  }

  @Test
  public void testContainsShouldReturnCorrectBooleanForAllClasses() {
    Product product = createProduct();
    Assert.assertFalse(stock.contains(product));

    stock.add(product);
    Assert.assertTrue(stock.contains(product));

    product.setLabel("not_present_label");
    Assert.assertFalse(stock.contains(product));
  }

  @Test
  public void testAddProductShouldStoreTheCorrectProduct() {
    Product product = createProduct();
    stock.add(product);
    Assert.assertTrue(stock.contains(product));
  }



  private Product createProduct() {
    return new Product("test_label", 3.00, 1);
  }
}