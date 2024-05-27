package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
  private static final double PRICE = 2.50;
  private static final double INCREASE_KG_VALUE = 7.50;

  public AquaticAnimal(String name, String kind, int kg) {
    super(name, kind, kg, PRICE);
  }

  @Override
  public void eat() {
    super.increaseWeight(INCREASE_KG_VALUE);
  }
}
