package aquarium.entities.fish;

public abstract class BaseFish implements Fish {
  private String name;
  private String species;
  private int size;
  private double price;

  public BaseFish(String name, String species, int size, double price) {
    this.name = name;
    this.species = species;
    this.size = size;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public String getSpecies() {
    return this.species;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public double getPrice() {
    return this.price;
  }
}
