package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
  private static int SIZE = 5;

  public SaltwaterFish(String name, String species, double price) {
    super(name, species, SIZE, price);
  }

  @Override
  public void eat() {
    SIZE += 2;
  }
}
