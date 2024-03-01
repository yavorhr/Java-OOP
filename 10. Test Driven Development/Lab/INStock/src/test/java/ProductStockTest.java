import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


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

  @Test
  public void testFindByIdShouldReturnCorrectIfMiddleInStock() {
    fillProductsToStock(5);
    Product product = createProduct();
    stock.add(product);

    Product foundByIndex = stock.find(this.stock.getCount() - 1);

    Assert.assertNotNull(foundByIndex);
    Assert.assertEquals(product.getLabel(), foundByIndex.getLabel());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFindByNegativeIndex() {
    this.stock.find(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFindByIndexWhenEmptyStock() {
    this.stock.find(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFindByIndexGreaterThanSize() {
    fillProductsToStock(3);
    this.stock.find(this.stock.getCount());
  }

  @Test
  public void testChangeQuantityShouldSetNewQuantityToCorrectProduct() {
    Product product = createProduct();
    this.stock.add(product);

    int newQuantity = product.getQuantity() + 10;
    this.stock.changeQuantity(product.getLabel(), newQuantity);

    Product findByIndex = this.stock.find(0);
    Assert.assertNotNull(findByIndex);

    Assert.assertEquals(newQuantity, findByIndex.getQuantity());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeQuantityForItemNotPresent() {
    Product product = createProduct();
    this.stock.changeQuantity(product.getLabel(), product.getQuantity() + 10);
  }

  @Test
  public void testFindByLabelShouldReturnCorrectItem() {
    Product product = createProduct();
    this.stock.add(product);
    Product byLabel = this.stock.findByLabel(product.getLabel());

    Assert.assertNotNull(byLabel);
    Assert.assertEquals(byLabel.getLabel(), product.getLabel());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindByLabelWithNoSuchProductPresent() {
    fillProductsToStock(10);
    this.stock.findByLabel("invalid_label");
  }

  @Test
  public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProducts() {
    fillProductsToStock(10);
    Iterable<Product> iterableProducts = this.stock.findFirstByAlphabeticalOrder(6);

    Assert.assertNotNull(iterableProducts);
    Assert.assertEquals(6, createListFromIterable(iterableProducts).size());
  }

  @Test
  public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProductsAndTheyAreOrderedAlphabetically() {
    fillProductsToStock(10);
    Iterable<Product> iterableProducts = this.stock.findFirstByAlphabeticalOrder(6);
    Assert.assertNotNull(iterableProducts);

    List<Product> returnedProducts = createListFromIterable(iterableProducts);

    Assert.assertEquals(6, returnedProducts.size());

    Set<String> expectedLabels = returnedProducts.stream()
            .map(Product::getLabel)
            .collect(Collectors.toCollection(TreeSet::new));

    int index = 0;
    for (String expectedLabel : expectedLabels) {
      Assert.assertEquals(expectedLabel, returnedProducts.get(index).getLabel());
    }

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

  private List<Product> createListFromIterable(Iterable<Product> products) {
    List<Product> result = new ArrayList<>();

    for (Product product : products) {
      result.add(product);
    }

    return result;
  }

}