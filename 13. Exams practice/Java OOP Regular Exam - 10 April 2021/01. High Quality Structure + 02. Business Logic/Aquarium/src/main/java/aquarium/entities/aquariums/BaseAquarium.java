package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;
import aquarium.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
  private String name;
  private int capacity;
  private Collection<Decoration> decorations;
  private Collection<Fish> fishes;

  protected BaseAquarium(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.decorations = new ArrayList<>();
    this.fishes = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Collection<Decoration> getDecorations() {
    return this.decorations;
  }

  @Override
  public int calculateComfort() {
    return this.decorations.stream()
            .mapToInt(Decoration::getComfort)
            .sum();
  }

  @Override
  public void addFish(Fish fish) {
    Validator.validateIfEnoughCapacity(this.capacity);
    this.fishes.add(fish);
  }

  @Override
  public void removeFish(Fish fish) {
    this.fishes.remove(fish);
  }

  @Override
  public void addDecoration(Decoration decoration) {
    this.decorations.add(decoration);
  }

  @Override
  public void feed() {
    this.fishes.forEach(Fish::eat);
  }

  @Override
  public String getInfo() {

    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%s (%s):",
            this.getName(),
            this.getClass().getSimpleName()))
            .append(System.lineSeparator());

    sb.append(String.format("Fish: %s", getFishNames()));
    sb.append(String.format("Decorations: %d",
            this.decorations.size()))
            .append(System.lineSeparator());

    sb.append(String.format("Comfort: %d",
            this.calculateComfort()))
            .append(System.lineSeparator());

    return sb.toString().trim();
  }


  @Override
  public Collection<Fish> getFish() {
    return this.fishes;
  }

  private void setName(String name) {
    Validator.validateAquariumName(name);
    this.name = name;
  }

  // Helpers
  private String getFishNames() {
    return this.getFish().size() == 0
            ? "None"
            : this.getFish().stream()
            .map(Fish::getName)
            .collect(Collectors.joining(" "));
  }
}
