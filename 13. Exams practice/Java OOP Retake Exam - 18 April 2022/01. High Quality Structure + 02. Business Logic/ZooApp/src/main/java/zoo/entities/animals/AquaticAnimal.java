package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
  private static final double PRICE = 2.50;

  public AquaticAnimal(String name, String kind, int kg) {
    super(name, kind, kg, PRICE);
  }
}
