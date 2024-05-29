package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
  private static final double KILOGRAMS = 5.50;
  private static final double INCREASE_KG_VALUE = 5.70;

  public TerrestrialAnimal(String name, String kind, double price) {
    super(name, kind, KILOGRAMS, price);
  }

  @Override
  public void eat() {
    super.increaseWeight(INCREASE_KG_VALUE);
  }
}
