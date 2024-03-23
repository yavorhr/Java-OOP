package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
  private static int INITIAL_KG = 7;

  public ShorthairCat(String name, String breed, double price) {
    super(name, breed, INITIAL_KG, price);
  }

  @Override
  public void eating() {
    INITIAL_KG += 1;
  }
}
