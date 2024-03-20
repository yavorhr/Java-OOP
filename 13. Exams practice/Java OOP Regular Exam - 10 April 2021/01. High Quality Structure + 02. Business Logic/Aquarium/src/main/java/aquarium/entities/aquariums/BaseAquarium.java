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

  public BaseAquarium(String name, int capacity) {
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

  private void setName(String name) {
    Validator.validateAquariumName(name);
    this.name = name;
  }
}
