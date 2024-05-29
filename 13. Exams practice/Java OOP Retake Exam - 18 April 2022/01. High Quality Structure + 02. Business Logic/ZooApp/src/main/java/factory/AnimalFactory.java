package factory;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;

public class AnimalFactory {
  public static Animal create(String type, String name, String kind, double price) {
    Animal animal = null;

    switch (type) {
      case "AquaticAnimal" -> animal = new AquaticAnimal(name, kind, price);
      case "TerrestrialAnimal" -> animal = new TerrestrialAnimal(name, kind, price);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
    }
    return animal;
  }
}
