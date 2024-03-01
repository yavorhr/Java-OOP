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

  @Test
  public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
    fillProductsToStock(10);

    Iterable<Product> iterableProducts = this.stock.findFirstByAlphabeticalOrder(6);
    Assert.assertNotNull(iterableProducts);

    List<Product> list = createListFromIterable(iterableProducts);
    Assert.assertTrue(list.isEmpty());
  }

  @Test
  public void testFindAllInPriceRangeShouldReturnCorrectItemsWithCorrectOrders() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product5 = new Product("test_label_5", 5, 1);
    Product product6 = new Product("test_label_6", 6, 1);
    Product product7 = new Product("test_label_7", 7, 1);
    Product product9 = new Product("test_label_9", 9, 1);
    Product product10 = new Product("test_label_10", 10, 1);
    Product product11 = new Product("test_label_11", 11, 1);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product5);
    this.stock.add(product6);
    this.stock.add(product7);
    this.stock.add(product9);
    this.stock.add(product10);
    this.stock.add(product11);

    Iterable<Product> products = this.stock.findAllInRange(5, 10);
    Assert.assertNotNull(products);

    List<Product> listFromIterable = createListFromIterable(products);
    Assert.assertEquals(4, listFromIterable.size());

    Assert.assertEquals(10, listFromIterable.get(0).getPrice(), 0);
    Assert.assertEquals(9, listFromIterable.get(1).getPrice(), 0);
    Assert.assertEquals(7, listFromIterable.get(2).getPrice(), 0);
    Assert.assertEquals(6, listFromIterable.get(3).getPrice(), 0);
  }

  @Test
  public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenNotInRange() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product11 = new Product("test_label_11", 11, 1);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product11);

    Iterable<Product> products = this.stock.findAllInRange(5, 10);
    Assert.assertNotNull(products);

    List<Product> listFromIterable = createListFromIterable(products);
    Assert.assertTrue(listFromIterable.isEmpty());
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

  private <T> List<T> createListFromIterable(Iterable<T> products) {
    List<T> result = new ArrayList<>();

    for (T product : products) {
      result.add(product);
    }
    return result;
  }

}