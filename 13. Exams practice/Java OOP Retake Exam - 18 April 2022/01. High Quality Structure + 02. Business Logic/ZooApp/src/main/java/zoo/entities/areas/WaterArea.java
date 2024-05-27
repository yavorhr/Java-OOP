package zoo.entities.areas;

public class WaterArea extends BaseArea {
  private static int CAPACITY = 10;

  public WaterArea(String name) {
    super(name, CAPACITY);
  }
}
