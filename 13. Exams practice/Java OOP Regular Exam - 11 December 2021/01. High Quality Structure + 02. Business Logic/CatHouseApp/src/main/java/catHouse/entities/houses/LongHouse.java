package catHouse.entities.houses;

public class LongHouse extends BaseHouse{
  private static  int INIT_CAPACITY = 30;

  protected LongHouse(String name) {
    super(name, INIT_CAPACITY);
  }
}
