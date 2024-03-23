package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;
import catHouse.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House {
  private String name;
  private int capacity;
  private Collection<Toy> toys;
  private Collection<Cat> cats;

  public BaseHouse(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.toys = new ArrayList<>();
    this.cats = new ArrayList<>();
  }

  @Override
  public int sumSoftness() {
    return this.toys.stream()
            .mapToInt(Toy::getSoftness)
            .sum();
  }

  @Override
  public void addCat(Cat cat) {
    Validator.validateIfHouseCapacity(capacity);
    this.cats.add(cat);
    this.capacity--;
  }

  @Override
  public void removeCat(Cat cat) {
    this.cats.remove(cat);
    this.capacity++;
  }

  @Override
  public void buyToy(Toy toy) {

  }

  @Override
  public void feeding() {

  }

  @Override
  public String getStatistics() {
    return null;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {

  }

  @Override
  public Collection<Cat> getCats() {
    return this.cats;
  }

  @Override
  public Collection<Toy> getToys() {
    return this.toys;
  }
}
