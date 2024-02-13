import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money -= product.getCost();
    }

    private void setName(String name) {
        if (!NameValidator.isValid(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setMoney(double money) {
        if (!NumericValidator.isNoneNegative(money)) {
            throw new IllegalArgumentException(ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE);
        }
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.products.size() == 0 ? "Nothing bought" : getProducts(this.products));
    }

    private String getProducts(List<Product> products) {
        return products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }
}
