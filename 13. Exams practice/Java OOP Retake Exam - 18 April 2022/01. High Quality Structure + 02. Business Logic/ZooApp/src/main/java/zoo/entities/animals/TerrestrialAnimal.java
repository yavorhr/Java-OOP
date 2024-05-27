package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
  private static final double PRICE = 5.50;
  private static final double INCREASE_KG_VALUE = 5.70;


  public TerrestrialAnimal(String name, String kind, double kg) {
    super(name, kind, kg, PRICE);
  }

  @Override
  public void eat() {
    super.increaseWeight(INCREASE_KG_VALUE);
  }
}
