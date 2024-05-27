package zoo.entities.animals;

public abstract class TerrestrialAnimal extends BaseAnimal {
  private static final double PRICE = 5.50;

  public TerrestrialAnimal(String name, String kind, double kg) {
    super(name, kind, kg, PRICE);
  }
}
