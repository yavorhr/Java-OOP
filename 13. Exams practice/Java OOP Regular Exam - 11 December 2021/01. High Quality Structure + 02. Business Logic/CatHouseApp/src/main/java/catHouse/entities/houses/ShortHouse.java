package catHouse.entities.houses;

public class ShortHouse extends BaseHouse {
  private static int INIT_CAPACITY = 15;

  protected ShortHouse(String name) {
    super(name, INIT_CAPACITY);
  }
}
