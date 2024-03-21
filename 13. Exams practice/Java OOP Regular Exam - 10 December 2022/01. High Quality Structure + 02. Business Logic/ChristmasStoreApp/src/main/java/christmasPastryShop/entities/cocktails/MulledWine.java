package christmasPastryShop.entities.cocktails;

public class MulledWine extends BaseCocktail {
  private static final double PRICE = 3.50;

  public MulledWine(String name, int size, String brand) {
    super(name, size, PRICE, brand);
  }
}
