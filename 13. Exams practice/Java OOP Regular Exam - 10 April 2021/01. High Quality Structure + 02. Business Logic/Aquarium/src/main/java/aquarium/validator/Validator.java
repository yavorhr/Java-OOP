package aquarium.validator;

import aquarium.common.ExceptionMessages;

public class Validator {

  public static void validateFishName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.FISH_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateFishSpecies(String species) {
    if (species == null || species.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.SPECIES_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateFishPrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.FISH_PRICE_BELOW_OR_EQUAL_ZERO);
    }
  }

  public static void validateAquariumName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
    }
  }

  public static void validateIfEnoughCapacity(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NO_ENOUGH_CAPACITY);
    }
  }

}
