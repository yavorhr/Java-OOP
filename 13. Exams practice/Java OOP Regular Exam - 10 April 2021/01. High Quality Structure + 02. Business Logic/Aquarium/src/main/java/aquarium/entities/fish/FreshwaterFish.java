package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
  private static int SIZE = 3;

  public FreshwaterFish(String name, String species, double price) {
    super(name, species, SIZE, price);
  }

  @Override
  public void eat() {
    SIZE += 3;
  }
}
