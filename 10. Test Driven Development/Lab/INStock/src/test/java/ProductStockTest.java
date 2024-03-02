import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class ProductStockTest {
  private ProductStock stock;

  @Before
  public void setUp() {
    this.stock = new Instock();
  }

  // add(Product) & count()
  @Test
  public void testCountShouldReturnCorrectSize() {
    Assert.assertEquals(0, stock.getCount());
    stock.add(new Product());
    Assert.assertEquals(1, stock.getCount());
  }

  // contains
  @Test
  public void testContainsShouldReturnCorrectBooleanForAllClasses() {
    Product product = createProduct();
    Assert.assertFalse(stock.contains(product));

    stock.add(product);
    Assert.assertTrue(stock.contains(product));

    Assert.assertFalse(stock.contains(new Product("not_present_label",3.00, 1)));
  }

  @Test
  public void testAddProductShouldStoreTheCorrectProduct() {
    Product product = createProduct();
    stock.add(product);
    Assert.assertTrue(stock.contains(product));
  }

  // find(int)
  @Test
  public void testFindByIndexShouldReturnCorrectIfFirstItemInStock() {
    Product product = createProduct();
    stock.add(product);

    Product foundByIndex = stock.find(0);
    Assert.assertNotNull(foundByIndex);

    Assert.assertEquals(product.getLabel(), foundByIndex.getLabel());
  }

  @Test
  public void testFindByIndexShouldReturnCorrectIfLastItemInStock() {
    fillProductsToStock(5);
    Product product = createProduct();
    stock.add(product);

    Product foundByIndex = stock.find(this.stock.getCount() - 1);

    Assert.assertNotNull(foundByIndex);
    Assert.assertEquals(product.getLabel(), foundByIndex.getLabel());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFindByIndexNegativeIndex() {
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

  // changeQuantity(String,int)
  @Test
  public void testChangeQuantityShouldSetNewQuantityToCorrectProduct() {
    Product product = createProduct();
    this.stock.add(product);

    int newQuantity = product.getQuantity() + 10;
    this.stock.changeQuantity(product.getLabel(), newQuantity);

    Product productByIndex = this.stock.find(0);
    Assert.assertNotNull(productByIndex);

    Assert.assertEquals(newQuantity, productByIndex.getQuantity());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeQuantityForItemNotPresent() {
    Product product = createProduct();
    this.stock.changeQuantity(product.getLabel(), product.getQuantity() + 10);
  }

  // indByLabel(String)
  @Test
  public void testFindByLabelShouldReturnCorrectProduct() {
    Product product = createProduct();
    this.stock.add(product);

    Product productByLabel = this.stock.findByLabel(product.getLabel());
    Assert.assertNotNull(productByLabel);

    Assert.assertEquals(productByLabel.getLabel(), product.getLabel());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindByLabelWithNoSuchProductPresent() {
    fillProductsToStock(10);
    this.stock.findByLabel("invalid_label");
  }

  // findFirstByAlphabeticalOrder(int)
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
      Assert.assertEquals(expectedLabel, returnedProducts.get(index++).getLabel());
    }
  }

  @Test
  public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
    fillProductsToStock(10);

    Iterable<Product> iterableProducts = this.stock.findFirstByAlphabeticalOrder(11);
    Assert.assertNotNull(iterableProducts);

    List<Product> list = createListFromIterable(iterableProducts);
    Assert.assertTrue(list.isEmpty());
  }

  // findAllInPriceRange(double,double)
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

  // findAllByPrice(double)
  @Test
  public void testFindAllByPriceShouldReturnOnlyCorrectPricedProducts() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product3 = new Product("test_label_3", 5, 1);
    Product product4 = new Product("test_label_4", 5, 1);
    Product product5 = new Product("test_label_5", 5, 1);
    Product product6 = new Product("test_label_6", 5, 1);
    Product product7 = new Product("test_label_7", 10, 1);
    Product product8 = new Product("test_label_8", 11, 1);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product3);
    this.stock.add(product4);
    this.stock.add(product5);
    this.stock.add(product6);
    this.stock.add(product7);
    this.stock.add(product8);

    Iterable<Product> iterable = this.stock.findAllByPrice(5);
    Assert.assertNotNull(iterable);

    List<Product> products = createListFromIterable(iterable);
    Assert.assertEquals(4, products.size());

    for (Product product : products) {
      Assert.assertEquals(5, product.getPrice(), 0);
    }
  }

  @Test
  public void testFindAllByPriceShouldReturnEmptyCollectionWhenNoProductsWithPriceSpecified() {
    fillProductsToStock(10);
    Product product = stock.find(0);

    Assert.assertNotNull(product);

    Iterable<Product> iterable = this.stock.findAllByPrice(product.getPrice() + 10);
    Assert.assertNotNull(iterable);
    List<Product> products = createListFromIterable(iterable);

    Assert.assertTrue(products.isEmpty());
  }

  // findFirstMostExpensiveProducts(int)
  @Test
  public void testFindFirstMostExpensiveProductsWorksCorrect() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product3 = new Product("test_label_3", 3, 1);
    Product product4 = new Product("test_label_4", 4, 1);
    Product product5 = new Product("test_label_5", 5, 1);
    Product product6 = new Product("test_label_6", 6, 1);
    Product product7 = new Product("test_label_7", 7, 1);
    Product product8 = new Product("test_label_8", 8, 1);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product3);
    this.stock.add(product4);
    this.stock.add(product5);
    this.stock.add(product6);
    this.stock.add(product7);
    this.stock.add(product8);

    Iterable<Product> iterable = this.stock.findFirstMostExpensiveProducts(4);
    Assert.assertNotNull(iterable);

    List<Product> products = createListFromIterable(iterable);
    Assert.assertEquals(4, products.size());

    Assert.assertEquals(8, products.get(0).getPrice(), 0);
    Assert.assertEquals(7, products.get(1).getPrice(), 0);
    Assert.assertEquals(6, products.get(2).getPrice(), 0);
    Assert.assertEquals(5, products.get(3).getPrice(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindFirstMostExpensiveProductsThrowErrorWhenNotEnoughItems() {
    fillProductsToStock(10);
    this.stock.findFirstMostExpensiveProducts(15);
  }

  // findAllByQuantity(int)
  @Test
  public void testFindAllByQuantityReturnCorrectProducts() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product3 = new Product("test_label_3", 3, 1);
    Product product4 = new Product("test_label_4", 4, 1);
    Product product5 = new Product("test_label_5", 5, 1);
    Product product6 = new Product("test_label_6", 6, 10);
    Product product7 = new Product("test_label_7", 7, 10);
    Product product8 = new Product("test_label_8", 8, 10);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product3);
    this.stock.add(product4);
    this.stock.add(product5);
    this.stock.add(product6);
    this.stock.add(product7);
    this.stock.add(product8);

    Iterable<Product> iterable = this.stock.findAllByQuantity(10);
    Assert.assertNotNull(iterable);

    List<Product> products = createListFromIterable(iterable);
    Assert.assertEquals(3, products.size());

    Assert.assertEquals(10, products.get(0).getQuantity());
    Assert.assertEquals(10, products.get(1).getQuantity());
    Assert.assertEquals(10, products.get(2).getQuantity());
  }

  @Test
  public void testFindAllByQuantityReturnEmptyCollectionWhenNoSuchItems() {
    fillProductsToStock(10);

    Product product = stock.find(0);
    Assert.assertNotNull(product);

    Iterable<Product> iterable = stock.findAllByQuantity(product.getQuantity() + 10);
    List<Product> products = createListFromIterable(iterable);

    Assert.assertTrue(products.isEmpty());
  }

  // getIterable<Product>()
  @Test
  public void testGetIterableShouldReturnCorrectProducts() {
    Product product1 = new Product("test_label_1", 1, 1);
    Product product2 = new Product("test_label_2", 2, 1);
    Product product3 = new Product("test_label_3", 3, 1);
    Product product4 = new Product("test_label_4", 4, 1);
    Product product5 = new Product("test_label_5", 5, 1);
    Product product6 = new Product("test_label_6", 6, 10);
    Product product7 = new Product("test_label_7", 7, 10);
    Product product8 = new Product("test_label_8", 8, 10);

    this.stock.add(product1);
    this.stock.add(product2);
    this.stock.add(product3);
    this.stock.add(product4);
    this.stock.add(product5);
    this.stock.add(product6);
    this.stock.add(product7);
    this.stock.add(product8);

    Iterator<Product> iterable = this.stock.iterator();
    Assert.assertNotNull(iterable);

    List<Product> products = createListFromIterable(iterable);
    Assert.assertEquals(8, products.size());
  }

  @Test
  public void testGetIterableShouldReturnEmptyCollection() {
    Iterator<Product> iterable = this.stock.iterator();
    Assert.assertNotNull(iterable);

    List<Product> products = createListFromIterable(iterable);
    Assert.assertTrue(products.isEmpty());
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

  private <T> List<T> createListFromIterable(Iterator<T> products) {
    List<T> result = new ArrayList<>();

    while (products.hasNext()) {
      result.add(products.next());
    }
    return result;
  }
}