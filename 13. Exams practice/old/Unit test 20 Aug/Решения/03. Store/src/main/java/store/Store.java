package store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public int getCount() {
        return this.products.size();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can't be null");
        }
        if (product.getQuantity() <= 0) {
            throw new IllegalArgumentException("Product count can't be below or equal to zero.");
        }
        this.products.add(product);
    }

    public double buyProduct(String name, int quantity) {
        Product product = this
                .products
                .stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (product == null) {
            throw new IllegalArgumentException("There is no such product.");
        }

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("There is not enough quantity of this product.");
        }
        int productQuantity = product.getQuantity();
        double finalPrice = product.getPrice() * quantity;
        product.setQuantity(productQuantity - quantity);
        return finalPrice;
    }

    public Product getTheMostExpensiveProduct() {
        Product product = this
                .products
                .stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(1)
                .findFirst()
                .orElse(null);

        return product;
    }
}