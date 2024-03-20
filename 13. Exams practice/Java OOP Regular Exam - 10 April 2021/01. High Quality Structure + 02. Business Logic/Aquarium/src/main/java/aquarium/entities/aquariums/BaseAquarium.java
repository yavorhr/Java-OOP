package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;
import aquarium.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

  }

  @Override
  public String getInfo() {
    return null;
  }

  @Override
  public Collection<Fish> getFish() {
    return null;
  }

  private void setName(String name) {
    Validator.validateAquariumName(name);
    this.name = name;
  }
}
