package aquarium.factory;

import aquarium.common.ExceptionMessages;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;

public class FishFactory {
  public static Fish create(String type, String name, String species, Double price) {
    Fish fish = null;

    switch (type) {
      case "FreshwaterFish" -> fish = new FreshwaterFish(name, species, price);
      case "SaltwaterFish" -> fish = new SaltwaterFish(name, species, price);
      default -> throw new NullPointerException(ExceptionMessages.INVALID_FISH_TYPE);
    }
    return fish;
  }
}


