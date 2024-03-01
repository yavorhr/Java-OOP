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

  // Test for valid product first in DS last in DS and in the middle of DS
  // Test IndexOutOfBounds for less than 0 and greater or equal to size
  @Test
  public void testFindByIdShouldReturnCorrectIfFirstItemInStock() {
    Product product = createProduct();
    stock.add(product);

    Product foundByIndex = stock.find(0);
    Assert.assertNotNull(foundByIndex);

    Assert.assertEquals(product.getLabel(), foundByIndex.getLabel());
  }

  @Test
  public void testFindByIdShouldReturnCorrectIfLastItemInStock() {
    fillProductsToStock(5);
    Product product = createProduct();
    stock.add(product);

    Product foundByIndex = stock.find(this.stock.getCount() - 1);

    Assert.assertNotNull(foundByIndex);
    Assert.assertEquals(product.getLabel(), foundByIndex.getLabel());
  }


  // Helpers
  private Product createProduct() {
    return new Product("test_label", 3.00, 1);
  }

  private Product[] createMultipleProducts(int n) {
    Product[] products = new Product[n];

    for (int i = 0; i < n; i++) {
      products[i] = new Product("test_label" + i, 3.00, 1);
    }
    return products;
  }

  private void fillProductsToStock(int n) {
    Product[] products = createMultipleProducts(n);

    for (Product product : products) {
      this.stock.add(product);
    }
  }
}