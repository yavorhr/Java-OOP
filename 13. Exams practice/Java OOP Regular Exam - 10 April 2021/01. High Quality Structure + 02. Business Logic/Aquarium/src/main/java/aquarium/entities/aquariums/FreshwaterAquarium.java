package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
  private static final int CAPACITY = 50;

  protected FreshwaterAquarium(String name) {
    super(name, CAPACITY);
  }
}
