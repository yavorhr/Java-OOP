package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StoreTests {
    private Store store;
    private Product product;

    @Before
    public void SetUp() {
        this.store = new Store();
        this.product = new Product("Veggie", 4, 2.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsSholdThrExceptionUnmodifiableList() {
        store.getProducts().remove(0);
    }

    @Test
    public void testGetProductsWorksCorrect() {
        store.addProduct(product);
        List<Product> products = store.getProducts();
        Assert.assertEquals(product, products.get(0));
    }

    @Test
    public void testGetCountWorksCorrect() {
        store.addProduct(product);
        int expectedCount = 1;
        int count = store.getCount();
        Assert.assertEquals(expectedCount, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductShouldThrException() {
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductShouldThrExceptionQuantityBelowZero() {
        store.addProduct(new Product("Test", -4, 2.00));
    }

    @Test
    public void testBuyProductWorksCorrect() {
        store.addProduct(product);
        store.buyProduct("Veggie", 2);
        int expectedSum = 4;
        Assert.assertEquals(expectedSum, store.buyProduct("Veggie", 2), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyNullProductShouldThrException() {
        store.buyProduct("Veggie", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyNullProductShouldThrExceptionLowQuantity() {
        store.addProduct(product);
        store.buyProduct("Veggie", 6);
    }

    @Test
    public void testGetMostExpensiveProduct() {
        store.addProduct(product);
        Product testProduct = new Product("fruit", 3, 1.00);
        store.addProduct(testProduct);
        Product theMostExpensiveProduct = store.getTheMostExpensiveProduct();
        Assert.assertEquals(product,theMostExpensiveProduct);
    }

    @Test
    public void testGetMostExpensiveProductNull() {
        Product theMostExpensiveProduct = store.getTheMostExpensiveProduct();
        Assert.assertNull(theMostExpensiveProduct);
    }


}