package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;
import catHouse.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

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
    this.toys.add(toy);
  }

  @Override
  public void feeding() {
    this.cats.forEach(Cat::eating);
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("%s %s:",
            this.name, this.getClass().getSimpleName()))
            .append(System.lineSeparator());

    sb.append(String.format("Cats: %s", getCatNames()))
            .append(System.lineSeparator());

    sb.append(String.format("Toys: %d Softness: %d",
            this.toys.size(), this.getSoftness()))
            .append(System.lineSeparator());

    return sb.toString().trim();
  }

  private int getSoftness() {
    return this.toys.stream()
            .mapToInt(Toy::getSoftness)
            .sum();
  }

  private String getCatNames() {
    return this.cats.size() == 0
            ? "none"
            : this.cats.stream()
            .map(Cat::getName)
            .collect(Collectors.joining(", "));
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
