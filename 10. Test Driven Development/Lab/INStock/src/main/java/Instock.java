import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product p : this.products) {
            if (p.getLabel().equals(product.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        for (Product product : this.products) {
            if (product.getLabel().equals(label)) {
                product.setLabel(label);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Product find(int index) {
        return this.products.get(0);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product product : this.products) {
            if (product.getLabel().equals(label)) {
                return product;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > this.getCount()) {
            return new ArrayList<>();
        }
        return this.products.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double low, double high) {
        return this.products.stream()
                .filter(p -> p.getPrice() > low && p.getPrice() <= high)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products.stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.getCount()) {
            throw new IllegalArgumentException();
        }

        return this.products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
