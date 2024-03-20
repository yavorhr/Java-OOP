package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;
import aquarium.factory.AquariumFactory;
import aquarium.factory.DecorationFactory;
import aquarium.factory.FishFactory;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, Aquarium> aquariums;
  private Repository decorationRepository;

  public ControllerImpl() {
    this.aquariums = new HashMap<>();
    this.decorationRepository = new DecorationRepository();
  }

  @Override
  public String addAquarium(String aquariumType, String aquariumName) {
    Aquarium aquarium = AquariumFactory.create(aquariumType, aquariumName);
    this.aquariums.put(aquariumName, aquarium);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
  }

  @Override
  public String addDecoration(String type) {
    Decoration decoration = DecorationFactory.create(type);
    this.decorationRepository.add(decoration);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
  }

  @Override
  public String insertDecoration(String aquariumName, String decorationType) {
    Aquarium aquarium = this.aquariums.get(aquariumName);
    Decoration decoration = this.getDecoration(decorationType);
    aquarium.addDecoration(decoration);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
  }


  @Override
  public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
    Aquarium aquarium = this.aquariums.get(aquariumName);
    Fish fish = FishFactory.create(fishType, fishName, fishSpecies, price);

    boolean isWaterSuitable = validateIfWaterIsSuitable(aquariumName.getClass().getSimpleName(), fishType);

    if (!isWaterSuitable) {
      return "Water not suitable.";
    }

    aquarium.addFish(fish);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
  }

  @Override
  public String feedFish(String aquariumName) {
    Aquarium aquarium = this.aquariums.get(aquariumName);
    aquarium.feed();
    
    return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size())
  }

  @Override
  public String calculateValue(String aquariumName) {
    return null;
  }

  @Override
  public String report() {
    return null;
  }

  // Helpers

  private Decoration getDecoration(String decorationType) {
    Decoration decoration = this.decorationRepository.findByType(decorationType);
    if (decoration == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
    }
    return decoration;
  }

  private boolean validateIfWaterIsSuitable(String aquariumType, String fishType) {
    switch (aquariumType) {
      case "FreshwaterAquarium" -> {
        if (!fishType.equals("FreshWaterFish")) {
          return false;
        }
      }
      case "SaltwaterAquarium" -> {
        if (!fishType.equals("SaltWaterFish")) {
          return false;
        }
      }
    }
    return true;
  }

}
