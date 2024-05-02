package handball.entities.equipment;

public class Kneepad extends BaseEquipment {
  private final int PROTECTION = 120;
  private final double PRICE = 15;

  public Kneepad() {
    super(PROTECTION, PRICE);
  }
}
