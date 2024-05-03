package handball.core;

import handball.entities.gameplay.Gameplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, List<Gameplay>> gamePlays;

  public ControllerImpl() {
    this.gamePlays = new HashMap<>();
  }

  @Override
  public String addGameplay(String gameplayType, String gameplayName) {

    return null;
  }

  @Override
  public String addEquipment(String equipmentType) {
    return null;
  }

  @Override
  public String equipmentRequirement(String gameplayName, String equipmentType) {
    return null;
  }

  @Override
  public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
    return null;
  }

  @Override
  public String playInGameplay(String gameplayName) {
    return null;
  }

  @Override
  public String percentAdvantage(String gameplayName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
