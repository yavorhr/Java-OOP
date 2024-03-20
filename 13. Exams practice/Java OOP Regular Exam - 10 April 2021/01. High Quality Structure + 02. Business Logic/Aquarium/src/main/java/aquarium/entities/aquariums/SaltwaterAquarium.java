package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
  private static final int CAPACITY = 25;

  protected SaltwaterAquarium(String name) {
    super(name, CAPACITY);
  }
}
