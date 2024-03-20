package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.factory.AquariumFactory;
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
    return null;
  }

  @Override
  public String insertDecoration(String aquariumName, String decorationType) {
    return null;
  }

  @Override
  public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
    return null;
  }

  @Override
  public String feedFish(String aquariumName) {
    return null;
  }

  @Override
  public String calculateValue(String aquariumName) {
    return null;
  }

  @Override
  public String report() {
    return null;
  }
}
